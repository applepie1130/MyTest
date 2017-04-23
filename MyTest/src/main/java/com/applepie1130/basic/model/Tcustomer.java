package com.applepie1130.basic.model;

import java.io.Serializable;
import java.util.List;


public class Tcustomer implements Serializable {
	
	private static final long serialVersionUID = 8447665447246587925L;
	
	private String id;
	private String department;
	private Integer age;
	private String name;
	private String phonNumber;
	private String etc;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phonNumber
	 */
	public String getPhonNumber() {
		return phonNumber;
	}
	/**
	 * @param phonNumber the phonNumber to set
	 */
	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	/**
	 * @return the etc
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tcustomer [id=" + id + ", department=" + department + ", age=" + age + ", name=" + name
				+ ", phonNumber=" + phonNumber + ", etc=" + etc + "]";
	}
	
	
}
