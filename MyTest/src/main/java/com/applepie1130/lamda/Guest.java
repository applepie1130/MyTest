package com.applepie1130.lamda;

import java.io.Serializable;

public class Guest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer grade;
	private String name;
	private String company;

	public Guest() { }

	public Guest(int id, String name, String company, int grade) {
		this.id = id;
		this.grade = grade;
		this.name = name;
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public String getName() {
		return name;
	}

	public Integer getGrade() {
		return grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", grade=" + grade + ", name=" + name + ", company=" + company + "]";
	}
}