package com.huluset.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.huluset.base.PageInfo;
import com.huluset.dao.ai.ExtTemplateDao;
import com.huluset.dtos.ExtAttr;
import com.huluset.dtos.ExtTemplateDto;
import com.huluset.dtos.SkuInfo;
import com.huluset.dtos.SkuListDto;

@Repository("extTemplateDao")
public class ExtTemplateDaoImpl extends BaseDaoImpl implements ExtTemplateDao {
	public List<ExtTemplateDto> queryExtTemplate() {
		return getJdbcTemplate().query(
				"select * from SKU_BASIC_INFO",
				ParameterizedBeanPropertyRowMapper
						.newInstance(ExtTemplateDto.class));
	}

	public List<ExtAttr> queryExtAttr() {
		return getJdbcTemplate()
				.query("select oid as oid, column_id as columnId, group_id as groupId, label_name as labelName  from sku_template",
						ParameterizedBeanPropertyRowMapper
								.newInstance(ExtAttr.class));
	}

	public void doSaveSkuBasicInfo(SkuInfo skuInfo) {
		String insertSql = " insert into sku_basic_info (oid, sku, weight, standard_price, price_unit, length, width, height) "
				+ " values(?,?,?,?,?,?,?,?)";

		Object[] params = new Object[] { skuInfo.getOid(), skuInfo.getSku(),
				skuInfo.getWeight(), skuInfo.getStandardPrice(),
				skuInfo.getPriceUnit(), skuInfo.getLength(),
				skuInfo.getWidth(), skuInfo.getHeight() };
		getJdbcTemplate().update(insertSql, params);
	}

	public void doSaveSkuFitCountry(String skuOid, String[] countrys) {
		String insertSql = " insert into sku_fit_country (skuoid, country_id) "
				+ " values(?,?)";
		for (String countryId : countrys) {
			Object[] params = new Object[] { skuOid, countryId };
			getJdbcTemplate().update(insertSql, params);
		}
	}

	public void doRemoveSkuExtAttr(String oid) {
		String deleteSql = " delete from ext_properties where skuoid = ? ";
		Object[] params = new Object[] { oid };
		getJdbcTemplate().update(deleteSql, params);
	}

	public void doSaveSkuExtAttr(String oid, Map<String, String> extAttr) {
		String insertSql = " insert into ext_properties (oid, skuoid,column_id,column_value) "
				+ " values(?,?,?,?)";
		for (Entry<String, String> curAttr : extAttr.entrySet()) {
			if (curAttr.getValue() == null
					|| curAttr.getValue().trim().length() == 0)
				continue;
			Object[] params = new Object[] { UUID.randomUUID().toString(), oid,
					curAttr.getKey(), curAttr.getValue() };
			getJdbcTemplate().update(insertSql, params);
		}
	}
	
	public List<SkuListDto> querySku(PageInfo pageInfo) {
		
		String totalSql = " select count(1) from sku_basic_info sbi";
		String conSql = " where sbi ...";
		
		String selectSql = " select sbi.oid , sbi.sku, sbi.weight, sbi.standard_price as standardPrice , sbi.price_unit as priceUnit, sbi.length, sbi.width, sbi.height, otherinfo.keyword as keyWord from sku_basic_info sbi, ";
		String otherSql = " ( select skuoid as skuoid, string_agg(ep.column_value,',') as keyword from ext_properties ep where ep.column_id like '%generic_keywords%' group by ep.skuoid ) otherinfo ";
		String joinSql = " where sbi.oid = otherinfo.skuoid ";
		
		String finalSql = " select * from ( "+selectSql+otherSql+" ) as temp LIMIT ? OFFSET ?";
		
		Object[] params = new Object[] {};
		long total = getJdbcTemplate().queryForLong(totalSql);
		pageInfo.setTotal(Integer.parseInt(String.valueOf(total)));
		if(total > 0){
			Object[] params2 = new Object[] {pageInfo.getLimit(), pageInfo.getOffset()};
			return getJdbcTemplate().query(finalSql, params2, ParameterizedBeanPropertyRowMapper
					.newInstance(SkuListDto.class));
		}
		return null;
	}
}
