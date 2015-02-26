package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the user_xyz database table.
 * 
 */
@Entity
@Table(name="user_xyz")
public class UserXyz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;

	@Id
	private Integer id;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="user_name")
	private String userName;

	public UserXyz() {
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}