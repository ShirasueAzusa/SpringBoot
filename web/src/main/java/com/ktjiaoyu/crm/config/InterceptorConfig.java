package com.ktjiaoyu.crm.config;

import com.ktjiaoyu.crm.web.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathPatterns = {"/**"};
        String[] excludePathPatterns = {"/login", "/regist", "/statics/**"};
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
