package de.deloitte.commerce.aem.core.pojo;

import java.util.Date;

public class CategoryName {
	
	private Date createdAt;
	private String id;
	private String lastModifiedAt;
	private String name;
	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(String lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
