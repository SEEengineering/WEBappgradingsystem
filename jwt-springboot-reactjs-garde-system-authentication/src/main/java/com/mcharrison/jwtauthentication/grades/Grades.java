package com.mcharrison.jwtauthentication.grades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grades {

	@Id
	private String studentID;

	private String examID;
	private int Grade1;
	private int Grade2;
	private String comments;
	private String gradedBy;
	private int Overall;

	protected Grades() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Grades(String studentID, String examID, int grade1, int grade2, String comments,
			String gradedBy, int overall) {
		super();
		this.studentID = studentID;
		this.examID = examID;
		Grade1 = grade1;
		Grade2 = grade2;
		this.comments = comments;
		this.gradedBy = gradedBy;
		this.Overall = overall;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public int getGrade1() {
		return Grade1;
	}

	public void setGrade1(int grade1) {
		this.Grade1 = grade1;
	}

	public int getGrade2() {
		return Grade2;
	}

	public void setGrade2(int grade2) {
		this.Grade2 = grade2;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getGradedBy() {
		return gradedBy;
	}

	public void setGradedBy(String gradedBy) {
		this.gradedBy = gradedBy;
	}

	public int getOverall() {
		return Overall;
	}

	public void setOverall(int overall) {
		this.Overall = overall;
	}

}
