package com.ktjiaoyu.crm.config;

import com.ktjiaoyu.crm.web.filter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    //@Bean
    public FilterRegistrationBean<AuthorizationFilter> filterRegist() {
        FilterRegistrationBean<AuthorizationFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthorizationFilter());
        registration.setBeanName("AuthorizationFilter");
        registration.addUrlPatterns("/main");
        registration.setOrder(5);
        return registration;
    }
}
