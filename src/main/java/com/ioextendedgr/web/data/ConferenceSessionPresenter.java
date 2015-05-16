package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the conference_session_presenter database table.
 * 
 */
@Entity
@Table(name = "conference_session_presenter")
public class ConferenceSessionPresenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// bi-directional many-to-one association to ConferenceSession
	@ManyToOne
	@JoinColumn(name = "conference_session_id")
	private ConferenceSession conferenceSession;

	// bi-directional many-to-one association to Presenter
	@ManyToOne
	private Presenter presenter;

	public ConferenceSessionPresenter() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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