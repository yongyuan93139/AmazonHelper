package com.huluset.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huluset.base.PageInfo;
import com.huluset.dtos.ExtAttr;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.JsonResult;
import com.huluset.dtos.SkuInfo;
import com.huluset.dtos.SkuListDto;
import com.huluset.service.ai.ExtTemplateService;
import com.huluset.utils.JsonUtils;

@Controller
public class ExtTemplateController {
	@Autowired
	private ExtTemplateService extTemplateService;

	@RequestMapping("/extTemplate.do")
	public String toListPage(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		return "ExtTemplate";
	}

	@RequestMapping("/skuManage.do")
	public String toSkuManage(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		List<ExtAttr> dtos = extTemplateService.queryExtAttr();
		httpServletRequest.setAttribute("extAttr", JsonUtils.toJson(dtos));
		return "sku_manage";
	}
	
	@RequestMapping("/skuManage_query.do")
	public @ResponseBody Map<String, Object> skuQuery(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		// 查询SKU，带翻页
		String offset = httpServletRequest.getParameter("offset");
		String limit = httpServletRequest.getParameter("limit");
		PageInfo pageInfo = new PageInfo();
		pageInfo.setOffset(Integer.parseInt(offset));
		pageInfo.setLimit(Integer.parseInt(limit));
		
		List<SkuListDto> skuList = extTemplateService.querySku(pageInfo);
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("status", "success");
		jsonResult.put("records", skuList);
		jsonResult.put("total", pageInfo.getTotal());
		return jsonResult;
	}

	@RequestMapping("/skuManage_saveSku.do")
	public @ResponseBody Map<String, Object> saveSku(SkuInfo skuInfo,
			HttpServletRequest httpServletRequest) {
		extTemplateService.doSaveSku(skuInfo);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("status", "success");
		return jsonResult;
	}

	@RequestMapping("/extTemplate_query.do")
	public @ResponseBody Map<String, Object> query(ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		List<ExtAttr> dtos = extTemplateService.queryExtAttr();
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("status", "success");
		jsonResult.put("records", dtos);
		jsonResult.put("total", dtos.size());
		return jsonResult;
	}
}
