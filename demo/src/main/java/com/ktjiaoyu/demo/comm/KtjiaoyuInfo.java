package com.ktjiaoyu.demo.comm;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource("classpath:demo.properties")
@ConfigurationProperties(prefix = "com.ktjiaoyu")
@Getter
@Setter
public class KtjiaoyuInfo implements Serializable {
    private String name;
    private String email;
}
