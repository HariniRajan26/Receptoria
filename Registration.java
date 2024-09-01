package com.RecipeDatabase.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Registration {

	@Id
	private int userId;
	private int roleId;
	private String username;
	private String password;
	private Date dateOfBirth;
	private String email;
	private String mobileNo;
	private String gender;
	private String age;
	
	public Registration() {}
	
	
	
	public Registration(int userId, int roleId, String username, String password, Date dateOfBirth, String email,
			String mobileNo, String gender, String age) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.age = age;
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", roleId=" + roleId + ", username=" + username + ", password="
				+ password + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", gender=" + gender + ", age=" + age + "]";
	}


	
	
}
