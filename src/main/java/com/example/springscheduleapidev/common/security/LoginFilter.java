package com.example.springscheduleapidev.common.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    private static final  String [] WHITELIST = {"/","/signup","/login","/logout"};
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();

        if(!isWhiteList(uri)){
            HttpSession session = httpServletRequest.getSession();

            if(session == null || session.getAttribute(LoginInfo.LOGIN_INFO) == null){
                throw new RuntimeException("로그인이 필요합니다.");
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String uri){
        return PatternMatchUtils.simpleMatch(WHITELIST, uri);
    }
}
