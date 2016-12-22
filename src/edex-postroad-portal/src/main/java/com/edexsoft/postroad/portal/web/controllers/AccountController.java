package com.edexsoft.postroad.portal.web.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller("web/account")
public class AccountController {

//	@Autowired
//	@Qualifier("UserService")
//	private IUserService UserService;
	
//	@Autowired
//	@Qualifier("EdexAuthenticationManager")
//	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value = { "/account", "/account/login" }, method = RequestMethod.GET)
	public ModelAndView Login() {
		String sView = "/web/account/login";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
	}

	@RequestMapping(value = { "/account/login2" }, method = RequestMethod.POST)
	public ModelAndView Login(@RequestParam("account") String account, @RequestParam("password") String password, String r) {
		
		List<GrantedAuthority> lstAuthority = new ArrayList<GrantedAuthority>();
		lstAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		Authentication result = new UsernamePasswordAuthenticationToken(account, password, lstAuthority);
		
//		Authentication request = new UsernamePasswordAuthenticationToken(account, password);
//		Authentication result = authenticationManager.authenticate(request);
		
		// 存入线程上下文
		SecurityContextHolder.getContext().setAuthentication(result);
		
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();		
//		Set<String> roles = AuthorityUtils.authorityListToSet(authorities);
//		
//		if (roles.contains("ROLE_ADMIN")) {
//		    response.sendRedirect("/root/home/index");
//		} else if (roles.contains("ROLE_MEMBER")) {
//		    response.sendRedirect("/member/home/index");
//		}
		
		// String sView = "/web/account/login";
		String sView = "redirect:/root/home/index";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
		
	}

	@RequestMapping("/account/register")
	public ModelAndView Register() {
		String sView = "/web/account/register";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// map.put("userName", name);
		return new ModelAndView(sView, oModel);
	}
	
}
