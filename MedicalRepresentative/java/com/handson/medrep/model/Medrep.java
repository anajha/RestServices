package com.handson.medrep.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This is the Parent MedicalRepresentative model class for creating the parent table
@Entity
@Table(name="medrep")
public class Medrep {
		
	@Column(name="representativeFirstName")
	private String representativeFirstName;
	
	@Column(name="representativeLastName")
	private String representativeLastName;
	
	@Column(name="companyId")
	private String companyId;
	
	@Column(name="representativeEmployeeId")
	private String representativeEmployeeId;
	
	@Column(name="representativeAddress")
	private String representativeAddress;
	
	@Column(name="representativeCountry")
	private String representativeCountry;
	
	@Column(name="representativeState")
	private String representativeState;
	
	@Column(name="representativeCity")
	private String representativeCity;
	
	@Column(name="representativePinCode")
	private String representativePinCode;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "medrep",fetch = FetchType.EAGER)
	private Set<Drugs> drugList=new HashSet<Drugs>();
	
	public Medrep(){}

	public Medrep(String representativeFirstName, String representativeLastName, String companyId,
			String representativeEmployeeId, String representativeAddress, String representativeCountry,
			String representativeState, String representativeCity, String representativePinCode, Set<Drugs> drugList) {
		this.representativeFirstName = representativeFirstName;
		this.representativeLastName = representativeLastName;
		this.companyId = companyId;
		this.representativeEmployeeId = representativeEmployeeId;
		this.representativeAddress = representativeAddress;
		this.representativeCountry = representativeCountry;
		this.representativeState = representativeState;
		this.representativeCity = representativeCity;
		this.representativePinCode = representativePinCode;
		this.drugList = drugList;
	}

	public String getRepresentativeFirstName() {
		return representativeFirstName;
	}

	public void setRepresentativeFirstName(String representativeFirstName) {
		this.representativeFirstName = representativeFirstName;
	}

	public String getRepresentativeLastName() {
		return representativeLastName;
	}

	public void setRepresentativeLastName(String representativeLastName) {
		this.representativeLastName = representativeLastName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRepresentativeEmployeeId() {
		return representativeEmployeeId;
	}

	public void setRepresentativeEmployeeId(String representativeEmployeeId) {
		this.representativeEmployeeId = representativeEmployeeId;
	}

	public String getRepresentativeAddress() {
		return representativeAddress;
	}

	public void setRepresentativeAddress(String representativeAddress) {
		this.representativeAddress = representativeAddress;
	}

	public String getRepresentativeCountry() {
		return representativeCountry;
	}

	public void setRepresentativeCountry(String representativeCountry) {
		this.representativeCountry = representativeCountry;
	}

	public String getRepresentativeState() {
		return representativeState;
	}

	public void setRepresentativeState(String representativeState) {
		this.representativeState = representativeState;
	}

	public String getRepresentativeCity() {
		return representativeCity;
	}

	public void setRepresentativeCity(String representativeCity) {
		this.representativeCity = representativeCity;
	}

	public String getRepresentativePinCode() {
		return representativePinCode;
	}

	public void setRepresentativePinCode(String representativePinCode) {
		this.representativePinCode = representativePinCode;
	}

	public Set<Drugs> getDrugList() {
		return drugList;
	}

	public void setDrugList(Set<Drugs> drugList) {
		this.drugList = drugList;
	}
	
}
