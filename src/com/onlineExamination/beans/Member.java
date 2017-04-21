package com.onlineExamination.beans;

import java.io.Serializable;
import java.util.Random;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String name;
	private String type;
	private String password;
	private String validationcode;
	private int authentication;

	public Member() {
		super();
	}

	public Member(String email, String name, String type, String password, String validationcode, int authentication) {
		super();
		this.email = email;
		this.name = name;
		this.type = type;
		this.password = password;
		this.validationcode = validationcode;
		this.authentication = authentication;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidationcode() {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + " ");
		for (int i = 0; i < 5; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);
		return sb.toString();
	}

	public void setValidationcode(String validationcode) {
		this.validationcode = validationcode;
	}

	public int getAuthentication() {
		return authentication;
	}

	public void setAuthentication(int Authentication) {
		this.authentication = Authentication;
	}
}
