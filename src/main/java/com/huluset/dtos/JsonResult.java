package com.huluset.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonResult {
	private boolean success;
	private String Result = "OK";
	private int TotalRecordCount;
	private List Records;
	private Map<String, Object> data = new HashMap<String, Object>();
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void put(String key , Object value){
		this.data.put(key, value);
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public int getTotalRecordCount() {
		return TotalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		TotalRecordCount = totalRecordCount;
	}
	public List getRecords() {
		return Records;
	}
	public void setRecords(List records) {
		Records = records;
	}
}
