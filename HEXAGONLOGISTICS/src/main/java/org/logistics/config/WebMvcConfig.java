package org.logistics.config;

import org.logistics.util.LoginCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@SessionAttributes("authUser")
@ComponentScan(basePackages = "org.logistics.controller")
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	 @Bean
	    public LoginCheckInterceptor loginCheckInterceptor() {
	        return new LoginCheckInterceptor();
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(loginCheckInterceptor())
	                .addPathPatterns("/in/**").excludePathPatterns("/in/listArticle/**"); // 적용할 URL 패턴 지정
	    }

}
