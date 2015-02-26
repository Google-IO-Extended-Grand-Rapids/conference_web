package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name="room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="full_desc")
	private String fullDesc;

	@Column(name="short_desc")
	private String shortDesc;

	//bi-directional many-to-one association to ConferenceSession
	@OneToMany(mappedBy="room")
	private List<ConferenceSession> conferenceSessions;

	//bi-directional many-to-one association to Conference
	@ManyToOne
	private Conference conference;

	public Room() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullDesc() {
		return this.fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public List<ConferenceSession> getConferenceSessions() {
		return this.conferenceSessions;
	}

	public void setConferenceSessions(List<ConferenceSession> conferenceSessions) {
		this.conferenceSessions = conferenceSessions;
	}

	public ConferenceSession addConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().add(conferenceSession);
		conferenceSession.setRoom(this);

		return conferenceSession;
	}

	public ConferenceSession removeConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().remove(conferenceSession);
		conferenceSession.setRoom(null);

		return conferenceSession;
	}

	public Conference getConference() {
		return this.conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

}