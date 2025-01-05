package com.poly;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poly.interceptor.GlobalInterceptor;



@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	GlobalInterceptor authglobaInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(authglobaInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**", "/assets/**");
	}
}