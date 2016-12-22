package com.edexsoft.postroad.portal.spring.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class EdexAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
//		response.sendRedirect(request.getContextPath());
//		HttpSession session = request.getSession();
//		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();		
		Set<String> roles = AuthorityUtils.authorityListToSet(authorities);
		
		if (roles.contains("ROLE_ADMIN")) {
		    response.sendRedirect("/root/home/index");
		} else if (roles.contains("ROLE_MEMBER")) {
		    response.sendRedirect("/member/home/index");
		}
		
	}
}
