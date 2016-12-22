package com.edexsoft.postroad.portal.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// 简单的只为应用程序的所有URL注册springSecurityFilterChain过滤器。
public class PortalSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	
//	// 如果没有使用Spring MVC 或Spring , 需要传递SecurityConfig到超类来确保配置被使用
//	public PortalSecurityInitializer() {
//		super(WebSecurityConfig.class);
//	}
	
}
