//package com.example.mokkoji.security.jwt.handler;
//
//import com.example.mokkoji.security.jwt.exception.JwtAuthenticationException;
//import com.example.mokkoji.security.jwt.util.JwtProvider;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtProvider tokenProvider;
//    private final JwtAuthenticationFailureHandler failureHandler;
//    private final RequestMatcherHolder requestMatcherHolder;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        try {
//            /// 헤더에서 토큰 꺼내기
//            String authorization = request.getHeader("Authorization");
//
//            if (authorization != null && authorization.startsWith("Bearer ")) {
//                String token = authorization.substring(7);
//                log.info("JWT token: {}", token);
//
//                /// 토큰 검증
//                if (tokenProvider.validateToken(token)) {
//                    var authentication = tokenProvider.getAuthentication(token);
//
//                    /// 시큐리티 홀더에 해당 멤버 저장
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                } else {
//                    throw new JwtAuthenticationException("토큰이 잘못 되었습니다.");
//                }
//
//            } else {
//                throw new JwtAuthenticationException("토큰이 없습니다.");
//            }
//        }
//        catch (JwtAuthenticationException ex) {
//            log.warn("JWT 인증 실패: {}", ex.getMessage());
//            // 실패 핸들러 호출
//            failureHandler.commence(request, response, ex);
//            return;
//        }
//        log.info("통과");
//
//        filterChain.doFilter(request, response);
//    }
//
//    // 필터를 안거치도록 지정
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) {
//
//        boolean shouldSkip = requestMatcherHolder.getRequestMatchersByMinRole(null)
//                .matches(request);
//
//        log.info("요청 URL: {} | 필터 생략 여부: {}", request.getRequestURI(), shouldSkip);
//
//        return shouldSkip;
//    }
//
//}
