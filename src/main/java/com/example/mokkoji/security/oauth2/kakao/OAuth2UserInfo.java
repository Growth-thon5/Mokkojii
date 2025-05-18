package com.example.mokkoji.security.oauth2.kakao;


public interface OAuth2UserInfo {

    String getProvider();
    String getProviderId();
    String getEmail();
    String getUserName();
    String getImageUrl();
}
