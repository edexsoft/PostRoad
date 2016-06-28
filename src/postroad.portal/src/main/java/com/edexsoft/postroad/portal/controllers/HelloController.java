package com.edexsoft.postroad.portal.controllers;

import java.util.HashMap;  
import java.util.Map;  
   
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;


@Controller  
public class HelloController {

    @RequestMapping(value = "/greeting")  
    public ModelAndView greeting(@RequestParam(value="name", defaultValue="World") String name) {  
         System.out.println("Hello " + name);  
         Map<String, Object> map = new HashMap<String, Object>();  
         map.put("userName", name);  
         return new ModelAndView("/hello",map);  
    }
//	@RequestMapping(value = "/greeting")  
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
}  