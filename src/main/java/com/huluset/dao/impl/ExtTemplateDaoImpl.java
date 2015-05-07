package com.huluset.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.huluset.dao.ai.ExtTemplateDao;
import com.huluset.dtos.ExtTemplateDto;

@Repository("extTemplateDao")
public class ExtTemplateDaoImpl extends BaseDaoImpl implements ExtTemplateDao {
	public List<ExtTemplateDto> queryExtTemplate() {
		return getJdbcTemplate().query("select * from SKU_BASIC_INFO", ParameterizedBeanPropertyRowMapper.newInstance(ExtTemplateDto.class));
	}
}
