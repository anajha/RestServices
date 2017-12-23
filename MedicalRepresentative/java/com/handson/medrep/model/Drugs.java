package com.handson.medrep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//This is the child Drug model class for creating the child table
@Entity
@Table(name="drugs")
public class Drugs {
 
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="about")
	private String about;
	
	@Column(name="symptoms")
	private String symptoms;
	
	@Column(name="moleculeName")
	private String moleculeName;
	
	@Column(name="productCode")
	private String productCode;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 public Medrep m;
	 
	 public Drugs(){}


	public Drugs(String name, String description, String about, String symptoms, String moleculeName,
			String productCode) {
		
		this.name = name;
		this.description = description;
		this.about = about;
		this.symptoms = symptoms;
		this.moleculeName = moleculeName;
		this.productCode = productCode;
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


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}


	public String getMoleculeName() {
		return moleculeName;
	}


	public void setMoleculeName(String moleculeName) {
		this.moleculeName = moleculeName;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}




