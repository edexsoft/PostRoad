package com.edexsoft.postroad.portal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;


@Controller  
public class AccountController {

	    @RequestMapping(value={"/account", "/account/login"})  
	    public ModelAndView login() {
	         Map<String, Object> map = new HashMap<String, Object>();  
//	         map.put("userName", name);  
	         return new ModelAndView("/account/login",map);  
	    }

}
