package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="create_dttm")
	private Timestamp createDttm;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="last_update_dttm")
	private Timestamp lastUpdateDttm;

	@Column(name="login_id")
	private String loginId;

	//bi-directional many-to-one association to ConferenceSessionRegistration
	@OneToMany(mappedBy="user")
	private List<ConferenceSessionRegistration> conferenceSessionRegistrations;

	//bi-directional many-to-one association to UserCred
	@OneToMany(mappedBy="user")
	private List<UserCred> userCreds;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateDttm() {
		return this.createDttm;
	}

	public void setCreateDttm(Timestamp createDttm) {
		this.createDttm = createDttm;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdateDttm() {
		return this.lastUpdateDttm;
	}

	public void setLastUpdateDttm(Timestamp lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public List<ConferenceSessionRegistration> getConferenceSessionRegistrations() {
		return this.conferenceSessionRegistrations;
	}

	public void setConferenceSessionRegistrations(List<ConferenceSessionRegistration> conferenceSessionRegistrations) {
		this.conferenceSessionRegistrations = conferenceSessionRegistrations;
	}

	public ConferenceSessionRegistration addConferenceSessionRegistration(ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().add(conferenceSessionRegistration);
		conferenceSessionRegistration.setUser(this);

		return conferenceSessionRegistration;
	}

	public ConferenceSessionRegistration removeConferenceSessionRegistration(ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().remove(conferenceSessionRegistration);
		conferenceSessionRegistration.setUser(null);

		return conferenceSessionRegistration;
	}

	public List<UserCred> getUserCreds() {
		return this.userCreds;
	}

	public void setUserCreds(List<UserCred> userCreds) {
		this.userCreds = userCreds;
	}

	public UserCred addUserCred(UserCred userCred) {
		getUserCreds().add(userCred);
		userCred.setUser(this);

		return userCred;
	}

	public UserCred removeUserCred(UserCred userCred) {
		getUserCreds().remove(userCred);
		userCred.setUser(null);

		return userCred;
	}

}