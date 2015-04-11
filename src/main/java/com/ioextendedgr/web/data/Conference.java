package com.ioextendedgr.web.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the conference database table.
 * 
 */
@Entity
@Table(name = "conference")
public class Conference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "create_dttm")
	private Timestamp createDttm;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "full_desc")
	private String fullDesc;

	@Column(name = "last_update_dttm")
	private Timestamp lastUpdateDttm;

	private String name;

	@Column(name = "short_desc")
	private String shortDesc;

	@Column(name = "start_date")
	private Timestamp startDate;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	// bi-directional many-to-one association to ConferenceSession
	@OneToMany(mappedBy = "conference")
	private List<ConferenceSession> conferenceSessions;
	
	// bi-directional many-to-one association to Room
	@OneToMany(mappedBy = "conference")
	private List<Room> rooms;

	// bi-directional many-to-one association to SponsorLevel
	@OneToMany(mappedBy = "conference")
	private List<SponsorLevel> sponsorLevels;

	public Conference() {
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

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<ConferenceSession> getConferenceSessions() {
		return this.conferenceSessions;
	}

	public void setConferenceSessions(List<ConferenceSession> conferenceSessions) {
		this.conferenceSessions = conferenceSessions;
	}

	public ConferenceSession addConferenceSession(
			ConferenceSession conferenceSession) {
		getConferenceSessions().add(conferenceSession);
		conferenceSession.setConference(this);

		return conferenceSession;
	}

	public ConferenceSession removeConferenceSession(
			ConferenceSession conferenceSession) {
		getConferenceSessions().remove(conferenceSession);
		conferenceSession.setConference(null);

		return conferenceSession;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setConference(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setConference(null);

		return room;
	}

	public List<SponsorLevel> getSponsorLevels() {
		return this.sponsorLevels;
	}

	public void setSponsorLevels(List<SponsorLevel> sponsorLevels) {
		this.sponsorLevels = sponsorLevels;
	}

	public SponsorLevel addSponsorLevel(SponsorLevel sponsorLevel) {
		getSponsorLevels().add(sponsorLevel);
		sponsorLevel.setConference(this);

		return sponsorLevel;
	}

	public SponsorLevel removeSponsorLevel(SponsorLevel sponsorLevel) {
		getSponsorLevels().remove(sponsorLevel);
		sponsorLevel.setConference(null);

		return sponsorLevel;
	}

    @PreUpdate
    public void onPreUpdate(){
        this.lastUpdateDttm = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    public void onPrePersist(){
        this.createDttm = new Timestamp(System.currentTimeMillis());
        this.lastUpdateDttm = new Timestamp(System.currentTimeMillis());
    }
}