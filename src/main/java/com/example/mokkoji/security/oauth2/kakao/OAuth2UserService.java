package com.example.mokkoji.security.oauth2.kakao;

import com.example.mokkoji.domain.user.entity.AuthProvider;
import com.example.mokkoji.domain.user.entity.Role;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        // 유저 정보(attributes) 가져오기
        Map<String, Object> oAuth2UserAttributes = super.loadUser(userRequest).getAttributes();

        // resistrationId 가져오기
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // userNameAttributeName 가져오기
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        log.info(registrationId + ": " + userNameAttributeName);

        // OAuth2를 바탕으로 정보 생성
        OAuth2UserInfo userInfo = null;

        userInfo = OAuth2UserInfoFactory.create(registrationId, oAuth2UserAttributes);
        log.info("userInfo: {}", userInfo.getProvider());
        log.info("userInfo: {}", userInfo.getUserName());
        log.info("userInfo: {}", userInfo.getEmail());

        AuthProvider provider = AuthProvider.valueOf(userInfo.getProvider());
        Optional<User> existUser = userRepository.findByProviderAndSocialId(provider, userInfo.getProviderId());

        User user = null;
        // 존재한다면 로그인
        if (existUser.isPresent()) {
            user = existUser.get();
            log.info("이미 로그인한 유저입니다.");

        }else{
           user = User.builder()
                    .provider(provider)
                    .socialId(userInfo.getProviderId())
                    .username(userInfo.getUserName())
                    .email(userInfo.getEmail())
                    .role(Role.PERSONAL) // 기본 역할 지정
                    .build();
            userRepository.save(user);
            log.info("신규 사용자 저장: {}", user.getId());
        }
        return PrincipalDetails.of(user,oAuth2UserAttributes);

    }
}
