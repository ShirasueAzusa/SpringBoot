package com.ktjiaoyu.crm.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        if (httpRequest.getSession().getAttribute("loginUser") == null) {
            httpResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter out = httpResponse.getWriter();
            out.print("""
                    <script>
                        alert('请先进行登录，再进行后续操作！（Filter控制）');
                        location.href = '" + httpRequest.getContextPath() + "/login.jsp';
                    </script>
                    """);
        } else filterChain.doFilter(servletRequest, servletResponse);
    }
}
