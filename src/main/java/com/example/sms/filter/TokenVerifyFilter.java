package com.example.ketangpai.filter;

import com.example.ketangpai.dto.Result;
import com.example.ketangpai.entity.User;
import com.example.ketangpai.util.ResponseUtil;
import com.example.ketangpai.util.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 名称
 * @date 2022/8/30 10:36
 */
@Component
public class TokenVerifyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("authorization");
        if (!(Objects.equals(request.getRequestURI(), "/login") || Objects.equals(request.getRequestURI(), "/register"))) {
            if (token == null) {
                ResponseUtil.returnJson(response, new Result<>(Result.UN_LOGIN, "未登录，正在前往登录"));
                return;
            }
            boolean verifyToken = TokenUtil.verifierToken(token);
            if (verifyToken) {
                filterChain.doFilter(request, response);
            } else {
                ResponseUtil.returnJson(response, new Result<>(Result.INFORMATION_IS_OUTDATED, "登录信息已过期，请重新登录"));
                return;
            }
        } else {
            if (token != null && TokenUtil.verifierToken(token)) {
                return;
            }
            filterChain.doFilter(request, response);
        }

    }

}
