package com.ioextendedgr.web.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conference_session_registration database table.
 * 
 */
@Entity
@Table(name="conference_session_registration")
public class ConferenceSessionRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	//bi-directional many-to-one association to ConferenceSession
	@ManyToOne
	@JoinColumn(name="conference_session_id")
	private ConferenceSession conferenceSession;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public ConferenceSessionRegistration() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConferenceSession getConferenceSession() {
		return this.conferenceSession;
	}

	public void setConferenceSession(ConferenceSession conferenceSession) {
		this.conferenceSession = conferenceSession;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}