package com.edexsoft.postroad.portal.controllers;

import java.util.HashMap;  
import java.util.Map;  
   
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;  


@Controller  
public class HelloController {  
       
    @RequestMapping("/greeting")  
    public ModelAndView greeting(@RequestParam(value="name", defaultValue="World") String name) {  
         System.out.println("Hello " + name);  
         Map<String, Object> map = new HashMap<String, Object>();  
         map.put("userName", name);  
         return new ModelAndView("/hello",map);  
    }  
        
}  