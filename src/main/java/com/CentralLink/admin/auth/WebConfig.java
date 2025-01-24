package com.CentralLink.admin.auth;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
@EnableWebMvc
@Component
public class WebConfig implements WebMvcConfigurer {
 
    @Autowired
    PrivilegeInterceptor privilegeInterceptor;
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Enable CORS for all endpoints (/**) and allow all HTTP methods
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Allow frontend URL
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")  // Allowed methods
                .allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Accept", "Origin")  // Allowed headers
                .allowCredentials(true);  // Allow credentials (cookies, headers, etc.)
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(privilegeInterceptor)
                .excludePathPatterns("/v3/api-docs", "/v3/api-docs/*",
                        "/swagger-ui.html", "/swagger-ui/**", "/static/**", "/api/auth/sendpdf", "/js/**", "/webjars/**");
    }
}