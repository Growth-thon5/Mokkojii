package com.example.mokkoji.global.config;

import com.example.mokkoji.security.oauth2.kakao.aop.CurrentUserIdArgumentResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CurrentUserIdArgumentResolver currentUserIdArgumentResolver;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public WebConfig(CurrentUserIdArgumentResolver currentUserIdArgumentResolver) {
        this.currentUserIdArgumentResolver = currentUserIdArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserIdArgumentResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 절대 경로로 변환해서 리소스 핸들링
        String absolutePath = uploadDir.startsWith("/") ? uploadDir : System.getProperty("user.dir") + "/" + uploadDir;

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + absolutePath + "/");
    }
}
