package com.ktjiaoyu.crm.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if (request.getSession().getAttribute("loginUser") != null) return true;
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('请先进行登录，再进行后续操作！（Interceptor控制）'); location.href = '" + request.getContextPath() + "/login.jsp';</script>");
        return false;
    }
}
