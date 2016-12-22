package com.edexsoft.postroad.portal.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("web/templates")
public class TemplatesController {
	
	@RequestMapping("/templates/fileupload/uploadfile")
	public ModelAndView UploadFile() {
		String sView = "/web/templates/fileupload/uploadfile";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// map.put("userName", name);
		return new ModelAndView(sView, oModel);
	}
	
	@RequestMapping("/templates/fileupload/uploadfiles")
	public ModelAndView UploadFiles() {
		String sView = "/web/templates/fileupload/uploadfiles";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// map.put("userName", name);
		return new ModelAndView(sView, oModel);
	}
}
