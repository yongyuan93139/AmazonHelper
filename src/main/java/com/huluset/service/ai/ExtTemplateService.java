package com.huluset.service.ai;

import java.util.List;

import com.huluset.base.PageInfo;
import com.huluset.dtos.ExtAttr;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.SkuInfo;
import com.huluset.dtos.SkuListDto;

public interface ExtTemplateService {
	public List<ExtTemplateDto> queryExtTemplate();
	List<ExtAttr> queryExtAttr();
	public void doSaveSku(SkuInfo skuInfo);
	void doSaveSkuBasicInfo(SkuInfo skuInfo);
	void doSaveSkuFitCountry(SkuInfo skuInfo);
	void doSaveSkuExtAttr(SkuInfo skuInfo);
	public List<SkuListDto> querySku(PageInfo pageInfo);
}
