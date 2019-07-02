package com.mkyong.customer.model;

public class EducationMaster {
	private int id;
	private String name;
	private String description;
	private String nameJP;
	private String descriptionJP;
	
	public EducationMaster() {}
	
	public EducationMaster(int id, String name, String description, String nameJP, String descriptionJP) {
		this.id = id;
		this.name = name;
		this.nameJP = nameJP;
		this.descriptionJP = descriptionJP;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNameJP() {
		return nameJP;
	}
	public void setNameJP(String nameJP) {
		this.nameJP = nameJP;
	}
	public String getDescriptionJP() {
		return descriptionJP;
	}
	public void setDescriptionJP(String descriptionJP) {
		this.descriptionJP = descriptionJP;
	}
	
	
}
