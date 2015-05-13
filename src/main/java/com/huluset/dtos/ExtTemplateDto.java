package com.huluset.dtos;

public class ExtTemplateDto implements RecidRecord {
	private String oid;
	private String sku;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getRecid() {
		return this.oid;
	}
}
