package com.huluset.dtos;

import java.math.BigDecimal;
import java.util.Map;

public class SkuInfo {
	private String oid;
	private String fitCountry;
	private String sku;
	private BigDecimal weight;
	private BigDecimal standardPrice;
	private String priceUnit;
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal height;
	private Map<String, String> extAttr;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getFitCountry() {
		return fitCountry;
	}
	public void setFitCountry(String fitCountry) {
		this.fitCountry = fitCountry;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public Map<String, String> getExtAttr() {
		return extAttr;
	}
	public void setExtAttr(Map<String, String> extAttr) {
		this.extAttr = extAttr;
	}
}
