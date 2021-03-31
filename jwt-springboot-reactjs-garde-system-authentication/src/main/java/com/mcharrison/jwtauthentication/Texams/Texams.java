package com.mcharrison.jwtauthentication.Texams;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Texams {

	@Id
	public String ID;

	public String description;
	public String moduleID;
	public String examinerID;

	protected Texams() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Texams(String iD, String description, String moduleID, String examinerID) {
		super();
		ID = iD;
		this.description = description;
		this.moduleID = moduleID;
		this.examinerID = examinerID;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

	public String getExaminerID() {
		return examinerID;
	}

	public void setExaminerID(String examinerID) {
		this.examinerID = examinerID;
	}

	

}
