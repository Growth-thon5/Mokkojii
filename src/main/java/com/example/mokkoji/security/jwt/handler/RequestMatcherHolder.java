package com.example.mokkoji.security.jwt.handler;

import com.example.mokkoji.domain.user.entity.Role;
import io.micrometer.common.lang.Nullable;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class RequestMatcherHolder {

    private final ConcurrentHashMap<String, RequestMatcher> reqMatcherCacheMap = new ConcurrentHashMap<>();

    /**
     * 모든 "/api/**" 경로의 요청에 대해 필터를 생략하도록 설정
     * @param minRole 최소 권한 (Nullable)
     * @return 생성된 RequestMatcher
     */
    public RequestMatcher getRequestMatchersByMinRole(@Nullable Role minRole) {
        // 캐시 키 고정
        String key = "API_SKIP";
        // AntPathRequestMatcher를 사용해 /api/** 모든 요청에 대해 매칭
        return reqMatcherCacheMap.computeIfAbsent(key, k ->
                new AntPathRequestMatcher("/api/**"));
    }
}
