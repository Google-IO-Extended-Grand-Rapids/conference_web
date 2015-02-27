package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="conference_session_type")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="create_dttm")
	private Timestamp createDttm;

	@Column(name="full_desc")
	private String fullDesc;

	@Column(name="last_update_dttm")
	private Timestamp lastUpdateDttm;

	private String name;

	@Column(name="parking_info")
	private String parkingInfo;

	@Column(name="short_desc")
	private String shortDesc;

	//bi-directional many-to-one association to Conference
	@OneToMany(mappedBy="location")
	private List<Conference> conferences;

	//bi-directional many-to-one association to LocationAddress
	@OneToMany(mappedBy="location")
	private List<LocationAddress> locationAddresses;

	public Location() {
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

	public String getParkingInfo() {
		return this.parkingInfo;
	}

	public void setParkingInfo(String parkingInfo) {
		this.parkingInfo = parkingInfo;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public List<Conference> getConferences() {
		return this.conferences;
	}

	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}

	public Conference addConference(Conference conference) {
		getConferences().add(conference);
		conference.setLocation(this);

		return conference;
	}

	public Conference removeConference(Conference conference) {
		getConferences().remove(conference);
		conference.setLocation(null);

		return conference;
	}

	public List<LocationAddress> getLocationAddresses() {
		return this.locationAddresses;
	}

	public void setLocationAddresses(List<LocationAddress> locationAddresses) {
		this.locationAddresses = locationAddresses;
	}

	public LocationAddress addLocationAddress(LocationAddress locationAddress) {
		getLocationAddresses().add(locationAddress);
		locationAddress.setLocation(this);

		return locationAddress;
	}

	public LocationAddress removeLocationAddress(LocationAddress locationAddress) {
		getLocationAddresses().remove(locationAddress);
		locationAddress.setLocation(null);

		return locationAddress;
	}

}