package com.huluset.dao.ai;

import java.util.List;
import java.util.Map;

import com.huluset.base.PageInfo;
import com.huluset.dtos.ExtAttr;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.SkuInfo;
import com.huluset.dtos.SkuListDto;

public interface ExtTemplateDao extends BaseDao {
	public List<ExtTemplateDto> queryExtTemplate();

	List<ExtAttr> queryExtAttr();

	public void doSaveSkuBasicInfo(SkuInfo skuInfo);

	public void doSaveSkuFitCountry(String skuOid, String[] countrys);

	public void doRemoveSkuExtAttr(String oid);

	public void doSaveSkuExtAttr(String oid, Map<String, String> extAttr);

	public List<SkuListDto> querySku(PageInfo pageInfo);
}
