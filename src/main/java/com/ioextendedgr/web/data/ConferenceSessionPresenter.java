package com.ioextendedgr.web.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conference_session_presenter database table.
 * 
 */
@Entity
@Table(name="conference_session_presenter")
public class ConferenceSessionPresenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	//bi-directional many-to-one association to ConferenceSession
	@OneToMany(mappedBy="conferenceSessionPresenter")
	private List<ConferenceSession> conferenceSessions;

	//bi-directional many-to-one association to ConferenceSession
	@ManyToOne
	@JoinColumn(name="conference_session_id")
	private ConferenceSession conferenceSession;

	//bi-directional many-to-one association to Presenter
	@ManyToOne
	private Presenter presenter;

	public ConferenceSessionPresenter() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ConferenceSession> getConferenceSessions() {
		return this.conferenceSessions;
	}

	public void setConferenceSessions(List<ConferenceSession> conferenceSessions) {
		this.conferenceSessions = conferenceSessions;
	}

	public ConferenceSession addConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().add(conferenceSession);
		conferenceSession.setConferenceSessionPresenter(this);

		return conferenceSession;
	}

	public ConferenceSession removeConferenceSession(ConferenceSession conferenceSession) {
		getConferenceSessions().remove(conferenceSession);
		conferenceSession.setConferenceSessionPresenter(null);

		return conferenceSession;
	}

	public ConferenceSession getConferenceSession() {
		return this.conferenceSession;
	}

	public void setConferenceSession(ConferenceSession conferenceSession) {
		this.conferenceSession = conferenceSession;
	}

	public Presenter getPresenter() {
		return this.presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}