/**
 * 
 */
package com.applepie1130.basic.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.extern.log4j.Log4j;


@Data
@Log4j
public class Tcustomer implements Serializable {
	
	private static final long serialVersionUID = 5511268084215137799L;
	
	private static String id;
	private static String name;
	private static Integer age;
	private static String phonNumber;
	private static String address;
	private static List<Tcustomer> tcustomerList;
	
	public static List<Tcustomer> getTcustomerList() {
		return tcustomerList;
	}
	public static void setTcustomerList(List<Tcustomer> tcustomerList) {
		Tcustomer.tcustomerList = tcustomerList;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		Tcustomer.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Tcustomer.name = name;
	}
	public static Integer getAge() {
		return age;
	}
	public static void setAge(Integer age) {
		Tcustomer.age = age;
	}
	public static String getPhonNumber() {
		return phonNumber;
	}
	public static void setPhonNumber(String phonNumber) {
		Tcustomer.phonNumber = phonNumber;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Tcustomer.address = address;
	}
	
}
