package de.deloitte.commerce.aem.core.pojo;

import java.util.List;

public class CategoryAttributePOJO {
	
	private int count;
	private int offset;
	private List<CategoryName> results;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public List<CategoryName> getResults() {
		return results;
	}
	public void setResults(List<CategoryName> results) {
		this.results = results;
	}
	
	

}
