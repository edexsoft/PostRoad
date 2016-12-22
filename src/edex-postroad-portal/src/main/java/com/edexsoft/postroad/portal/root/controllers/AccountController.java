package com.edexsoft.postroad.portal.root.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("root/account")
public class AccountController {
	@RequestMapping(value = { "/root/account", "/root/account/login" }, method = RequestMethod.GET)
	public ModelAndView Login() {
		String sView = "/root/account/login";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
	}

	@RequestMapping(value = "/root/account/login", method = RequestMethod.POST)
	public ModelAndView Login(String account, String password, boolean rememberMe) {
		String sView = "/root/account/login";
		Map<String, Object> oModel = new HashMap<String, Object>();
		return new ModelAndView(sView, oModel);
	}

	@RequestMapping("/root/account/register")
	public ModelAndView Register() {
		String sView = "/root/account/register";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
	}

}
