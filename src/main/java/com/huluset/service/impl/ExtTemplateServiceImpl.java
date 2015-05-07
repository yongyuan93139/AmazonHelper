package com.huluset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.huluset.dao.ai.ExtTemplateDao;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.service.ai.ExtTemplateService;

@Service("extTemplateService")
public class ExtTemplateServiceImpl implements ExtTemplateService {

	@Autowired
	private ExtTemplateDao extTemplateDao;
	
	public List<ExtTemplateDto> queryExtTemplate(){
		return extTemplateDao.queryExtTemplate();
	}
}
