package com.mcharrison.jwtauthentication.module;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class Module {

	@Id
	private String ID;

	private String title;
	private String description;
	private String lecturerID;

	protected Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Module(String ID, String title, String description, String lecturerID) {
		super();
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.lecturerID = lecturerID;
	}

	public String getId() {
		return ID;
	}

	public void setId(String ID) {
		this.ID = ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

}
