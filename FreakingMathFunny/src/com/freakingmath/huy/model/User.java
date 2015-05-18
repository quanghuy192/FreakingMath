package com.freakingmath.huy.model;

import java.io.Serializable;

/**
 * @author Huy
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private String password;
	private String name;
	private String email;
	private String address;
	private int phoneNumber;
	
	// Singleton

//	private static User user = new User();

	/**
	 * Private contructor
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return tra lai mot doi tuong duy nhat
	 */
	/*public synchronized static User getInstance() {
		return user;
	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
