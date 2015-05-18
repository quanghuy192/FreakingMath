package com.freakingmath.huy.model;

import java.io.Serializable;

public class UserLogin extends User implements Serializable {
	
	private String type = "login";

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	

}
