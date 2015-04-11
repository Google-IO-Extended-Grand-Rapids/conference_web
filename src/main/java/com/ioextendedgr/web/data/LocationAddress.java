package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the location_address database table.
 * 
 */
@Entity
@Table(name="location_address")
public class LocationAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="address_1")
	private String address1;

	@Column(name="address_2")
	private String address2;

	private String city;

	@Column(name="create_dttm")
	private Timestamp createDttm;

	@Column(name="last_update_dttm")
	private Timestamp lastUpdateDttm;

	private String latitude;

	private String longitude;

	private String state;

	@Column(name="zip_code")
	private String zipCode;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	public LocationAddress() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getCreateDttm() {
		return this.createDttm;
	}

	public void setCreateDttm(Timestamp createDttm) {
		this.createDttm = createDttm;
	}

	public Timestamp getLastUpdateDttm() {
		return this.lastUpdateDttm;
	}

	public void setLastUpdateDttm(Timestamp lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}