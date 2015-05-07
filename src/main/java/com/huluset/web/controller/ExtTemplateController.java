package com.huluset.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huluset.service.ai.ExtTemplateService;

@Controller
@RequestMapping("/extTemplate.do")
public class ExtTemplateController {
	@Autowired
	private ExtTemplateService extTemplateService;
	
	@RequestMapping
	public String load(ModelMap modelMap, HttpServletRequest httpServletRequest) {
		System.out.println(extTemplateService.queryExtTemplate());
		return "ExtTemplate";
	}
}
