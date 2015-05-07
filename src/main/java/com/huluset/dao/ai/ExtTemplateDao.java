package com.huluset.dao.ai;

import java.util.List;

import com.huluset.dtos.ExtTemplateDto;

public interface ExtTemplateDao extends BaseDao {
	public List<ExtTemplateDto> queryExtTemplate();
}
