package com.example.mokkoji.security.oauth2.kakao;

import java.util.Map;


public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo create(String registrationId, Map<String, Object> attributes) {
        OAuth2UserInfo userInfo;

        switch (registrationId.toUpperCase()) {
            case "KAKAO":
                userInfo = new KakaoUserInfo(attributes);
                break;
            default:
                throw new IllegalArgumentException("Unknown provider: " + registrationId);
        }
        return userInfo;
    }

}
