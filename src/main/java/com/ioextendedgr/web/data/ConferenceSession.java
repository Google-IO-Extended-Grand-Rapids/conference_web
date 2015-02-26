package com.ioextendedgr.web.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


/**
 * The persistent class for the conference_session database table.
 * 
 */
@Entity
@Table(name="conference_session")
@TypeDef(name="interval", typeClass = Interval.class)
public class ConferenceSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="create_dttm")
	private Timestamp createDttm;

	@Type(type="interval") 
	private Long duration;

	@Column(name="full_desc")
	private String fullDesc;

	@Column(name="last_update_dttm")
	private Timestamp lastUpdateDttm;

	private String name;

	@Column(name="short_desc")
	private String shortDesc;

	@Column(name="start_dttm")
	private Timestamp startDttm;

	//bi-directional many-to-one association to Conference
	@ManyToOne
	private Conference conference;

	//bi-directional many-to-one association to ConferenceSessionPresenter
	@ManyToOne
	@JoinColumn(name="conference_session_presenter_id")
	private ConferenceSessionPresenter conferenceSessionPresenter;

	//bi-directional many-to-one association to ConferenceSessionType
	@ManyToOne
	@JoinColumn(name="conference_session_type_id")
	private ConferenceSessionType conferenceSessionType;

	//bi-directional many-to-one association to Room
	@ManyToOne
	private Room room;

	//bi-directional many-to-one association to ConferenceSessionPresenter
	@OneToMany(mappedBy="conferenceSession")
	private List<ConferenceSessionPresenter> conferenceSessionPresenters;

	//bi-directional many-to-one association to ConferenceSessionRegistration
	@OneToMany(mappedBy="conferenceSession")
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

	public Object getDuration() {
		return this.duration;
	}
	
	
	@Type(type = "interval") 
	public void setDuration(Long duration) {
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

	public ConferenceSessionPresenter getConferenceSessionPresenter() {
		return this.conferenceSessionPresenter;
	}

	public void setConferenceSessionPresenter(ConferenceSessionPresenter conferenceSessionPresenter) {
		this.conferenceSessionPresenter = conferenceSessionPresenter;
	}

	public ConferenceSessionType getConferenceSessionType() {
		return this.conferenceSessionType;
	}

	public void setConferenceSessionType(ConferenceSessionType conferenceSessionType) {
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

	public void setConferenceSessionPresenters(List<ConferenceSessionPresenter> conferenceSessionPresenters) {
		this.conferenceSessionPresenters = conferenceSessionPresenters;
	}

	public ConferenceSessionPresenter addConferenceSessionPresenter(ConferenceSessionPresenter conferenceSessionPresenter) {
		getConferenceSessionPresenters().add(conferenceSessionPresenter);
		conferenceSessionPresenter.setConferenceSession(this);

		return conferenceSessionPresenter;
	}

	public ConferenceSessionPresenter removeConferenceSessionPresenter(ConferenceSessionPresenter conferenceSessionPresenter) {
		getConferenceSessionPresenters().remove(conferenceSessionPresenter);
		conferenceSessionPresenter.setConferenceSession(null);

		return conferenceSessionPresenter;
	}

	public List<ConferenceSessionRegistration> getConferenceSessionRegistrations() {
		return this.conferenceSessionRegistrations;
	}

	public void setConferenceSessionRegistrations(List<ConferenceSessionRegistration> conferenceSessionRegistrations) {
		this.conferenceSessionRegistrations = conferenceSessionRegistrations;
	}

	public ConferenceSessionRegistration addConferenceSessionRegistration(ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().add(conferenceSessionRegistration);
		conferenceSessionRegistration.setConferenceSession(this);

		return conferenceSessionRegistration;
	}

	public ConferenceSessionRegistration removeConferenceSessionRegistration(ConferenceSessionRegistration conferenceSessionRegistration) {
		getConferenceSessionRegistrations().remove(conferenceSessionRegistration);
		conferenceSessionRegistration.setConferenceSession(null);

		return conferenceSessionRegistration;
	}

}