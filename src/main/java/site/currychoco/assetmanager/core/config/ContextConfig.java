package site.currychoco.assetmanager.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.currychoco.assetmanager.core.interceptor.CheckLoginInterceptor;

import java.util.Arrays;

@Configuration
public class ContextConfig implements WebMvcConfigurer {

    @Autowired
    private CheckLoginInterceptor checkLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(checkLoginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("/js/**", "/image/**", "/favicon.png"))
                .excludePathPatterns(Arrays.asList("/login", "/join"))
                .excludePathPatterns(Arrays.asList("/sync/**"))
                .excludePathPatterns(Arrays.asList("/account/**", "/error"));
    }
}
