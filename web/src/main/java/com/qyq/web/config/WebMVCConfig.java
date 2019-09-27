package com.qyq.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    //重写addResourceHandlers方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //访问URL                                  //资源所在位置
        registry.addResourceHandler("/**").addResourceLocations("classpath:/aaa/");
    }

    /**
     * CORS跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8086")
                .allowedMethods("*")
                .allowedHeaders("*");
        //  /**表示本应用的所有方法都会去处理跨域请求，allowedMethods表示允许通过的请求数，allowedHeaders则表示允许的请求头。
    }
}
