package com.huluset.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.huluset.base.PageInfo;
import com.huluset.dao.ai.ExtTemplateDao;
import com.huluset.dtos.ExtAttr;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.SkuInfo;
import com.huluset.dtos.SkuListDto;
import com.huluset.service.ai.ExtTemplateService;

@Service("extTemplateService")
public class ExtTemplateServiceImpl implements ExtTemplateService {

	@Autowired
	private ExtTemplateDao extTemplateDao;
	
	public List<ExtTemplateDto> queryExtTemplate(){
		return extTemplateDao.queryExtTemplate();
	}

	public List<ExtAttr> queryExtAttr() {
		return extTemplateDao.queryExtAttr();
	}
	public void doSaveSku(SkuInfo skuInfo) {
		String oid = UUID.randomUUID().toString();
		skuInfo.setOid(oid);
		doSaveSkuBasicInfo(skuInfo);
		doSaveSkuFitCountry(skuInfo);
		doSaveSkuExtAttr(skuInfo);
	}

	public void doSaveSkuExtAttr(SkuInfo skuInfo) {
		doRemoveSkuExtAttr(skuInfo.getOid());
		extTemplateDao.doSaveSkuExtAttr(skuInfo.getOid(), skuInfo.getExtAttr());
	}

	public void doRemoveSkuExtAttr(String oid) {
		extTemplateDao.doRemoveSkuExtAttr(oid);
	}

	public void doSaveSkuFitCountry(SkuInfo skuInfo) {
		String skuOid = skuInfo.getOid();
		String fitCountryStr = skuInfo.getFitCountry();
		String[] countrys = StringUtils.split(fitCountryStr, ",");
		if(countrys != null && countrys.length > 0){
			extTemplateDao.doSaveSkuFitCountry(skuOid, countrys);
		}
	}

	public void doSaveSkuBasicInfo(SkuInfo skuInfo) {
		extTemplateDao.doSaveSkuBasicInfo(skuInfo);
	}
	
	public List<SkuListDto> querySku(PageInfo pageInfo) {
		return extTemplateDao.querySku(pageInfo);
	}
}
