package com.example.mokkoji.security.jwt.handler;

import com.example.mokkoji.security.jwt.exception.JwtAuthenticationException;
import com.example.mokkoji.security.jwt.util.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider tokenProvider;
    private final JwtAuthenticationFailureHandler failureHandler;
    private final RequestMatcherHolder requestMatcherHolder;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String authorization = request.getHeader("Authorization");

            // 토큰이 없으면 바로 다음 필터로 통과
            if (authorization == null || !authorization.startsWith("Bearer ")) {
                log.info("Authorization 헤더에 토큰이 없거나 Bearer로 시작하지 않음, 필터 통과");
                filterChain.doFilter(request, response);
                return;
            }

            String token = authorization.substring(7);
            log.info("JWT token: {}", token);

            // 토큰 검증
            if (tokenProvider.validateToken(token)) {
                var authentication = tokenProvider.getAuthentication(token);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new JwtAuthenticationException("토큰이 잘못 되었습니다.");
            }

        } catch (JwtAuthenticationException ex) {
            log.warn("JWT 인증 실패: {}", ex.getMessage());
            failureHandler.commence(request, response, ex);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();
        boolean shouldSkip = uri.startsWith("/api/locations") || uri.startsWith("/api/storeList");

        log.info("요청 URI: {}, 필터 생략 여부: {}", uri, shouldSkip);
        return shouldSkip;
    }

}
