package com.huluset.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.JsonResult;
import com.huluset.service.ai.ExtTemplateService;

@Controller
public class ExtTemplateController {
	@Autowired
	private ExtTemplateService extTemplateService;

	@RequestMapping("/extTemplate.do")
	public String toListPage(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		return "ExtTemplate";
	}

	@RequestMapping("/extTemplate_query.do")
	public @ResponseBody JsonResult query(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		List<ExtTemplateDto> dtos = extTemplateService.queryExtTemplate();

		JsonResult jsonResult = new JsonResult();
		jsonResult.put("templateList", dtos);
		return jsonResult;
	}
}
