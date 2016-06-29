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
public class HomeController {

    @RequestMapping(value="/home/index")  
    public ModelAndView index() {
         Map<String, Object> map = new HashMap<String, Object>();  
//         map.put("userName", name);  
         return new ModelAndView("/home/index",map);  
    }
    
    @RequestMapping(value="/home/about")  
    public ModelAndView about() {
         Map<String, Object> map = new HashMap<String, Object>();  
//         map.put("userName", name);  
         return new ModelAndView("/home/about",map);  
    }
    
//	@RequestMapping("/greeting")  
//  public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//      model.addAttribute("name", name);
//      return "greeting";
//  }
    
//    @RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
//    public ModelAndView getDetail(@PathVariable(value="id") Integer id){
//        
//        ModelAndView modelAndView = new ModelAndView();  
//        modelAndView.addObject("id", id);  
//        modelAndView.setViewName("detail");  
//        return modelAndView;
//    }
}  