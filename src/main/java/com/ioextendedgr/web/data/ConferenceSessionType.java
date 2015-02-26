package com.ioextendedgr.web.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conference_session_type database table.
 * 
 */
@Entity
@Table(name="conference_session_type")
public class ConferenceSessionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String desc;

	private String name;

	//bi-directional many-to-one association to ConferenceSession
	@OneToMany(mappedBy="conferenceSessionType")
	private List<ConferenceSession> conferenceSessions;

	public ConferenceSessionType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ConferenceSession> getConferenceSessions() {
		return this.conferenceSessions;
	}

	public void setConferenceSessions(List<ConferenceSession> conferenceSessions) {
		this.conferenceSessions = conferenceSessions;
	}

	public ConferenceSession addConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().add(conferenceSession);
		conferenceSession.setConferenceSessionType(this);

		return conferenceSession;
	}

	public ConferenceSession removeConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().remove(conferenceSession);
		conferenceSession.setConferenceSessionType(null);

		return conferenceSession;
	}

}