package com.ioextendedgr.web.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * The persistent class for the conference_session database table.
 * 
 */
@Entity
@Table(name = "conference_session")
public class ConferenceSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "create_dttm")
	private Timestamp createDttm;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "full_desc")
	private String fullDesc;

	@Column(name = "last_update_dttm")
	private Timestamp lastUpdateDttm;

	private String name;

	@Column(name = "short_desc")
	private String shortDesc;

	@Column(name = "start_dttm")
	private Timestamp startDttm;

	// bi-directional many-to-one association to Conference
	@ManyToOne
	@JoinColumn(name = "conference_id")
	private Conference conference;

	// bi-directional many-to-one association to ConferenceSessionType
	@ManyToOne
	@JoinColumn(name = "conference_session_type_id")
	private ConferenceSessionType conferenceSessionType;

	// bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	// bi-directional many-to-one association to ConferenceSessionPresenter
	@OneToMany(mappedBy = "conferenceSession")
	private List<ConferenceSessionPresenter> conferenceSessionPresenters;

	// bi-directional many-to-one association to ConferenceSessionRegistration
	@OneToMany(mappedBy = "conferenceSession")
	private List<ConferenceSessionRegistration> conferenceSessionRegistrations;

	public ConferenceSession() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateDttm() {
		return this.createDttm;
	}

	public void setCreateDttm(Timestamp createDttm) {
		this.createDttm = createDttm;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getFullDesc() {
		return this.fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public Timestamp getLastUpdateDttm() {
		return this.lastUpdateDttm;
	}

	public void setLastUpdateDttm(Timestamp lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Timestamp getStartDttm() {
		return this.startDttm;
	}

	public void setStartDttm(Timestamp startDttm) {
		this.startDttm = startDttm;
	}

	public Conference getConference() {
		return this.conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public ConferenceSessionType getConferenceSessionType() {
		return this.conferenceSessionType;
	}

	public void setConferenceSessionType(
			ConferenceSessionType conferenceSessionType) {
		this.conferenceSessionType = conferenceSessionType;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<ConferenceSessionPresenter> getConferenceSessionPresenters() {
		return this.conferenceSessionPresenters;
	}

	public void setConferenceSessionPresenters(
			List<ConferenceSessionPresenter> conferenceSessionPresenters) {
		this.conferenceSessionPresenters = conferenceSessionPresenters;
	}

	public List<ConferenceSessionRegistration> getConferenceSessionRegistrations() {
		return this.conferenceSessionRegistrations;
	}

	public void setConferenceSessionRegistrations(
			List<ConferenceSessionRegistration> conferenceSessionRegistrations) {
		this.conferenceSessionRegistrations = conferenceSessionRegistrations;
	}

	public ConferenceSessionRegistration addConferenceSessionRegistration(
			ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().add(conferenceSessionRegistration);
		conferenceSessionRegistration.setConferenceSession(this);

		return conferenceSessionRegistration;
	}

	public ConferenceSessionRegistration removeConferenceSessionRegistration(
			ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().remove(
				conferenceSessionRegistration);
		conferenceSessionRegistration.setConferenceSession(null);

		return conferenceSessionRegistration;
	}

	@PreUpdate
	public void onPreUpdate() {
		this.lastUpdateDttm = new Timestamp(System.currentTimeMillis());
	}

	@PrePersist
	public void onPrePersist() {
		this.createDttm = new Timestamp(System.currentTimeMillis());
		this.lastUpdateDttm = new Timestamp(System.currentTimeMillis());
	}

}