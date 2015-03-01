package com.ioextendedgr.web.viewDto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ioextendedgr.web.util.DateTimeISO8601Serializer;

public class LocationView {

	private Integer id;
	private String name;
	private String shortDesc;
	private String fullDesc;
	private String parkingInfo;
	private Date createDttm;
	private Date lastUpdateDttm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getFullDesc() {
		return fullDesc;
	}
	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}
	public String getParkingInfo() {
		return parkingInfo;
	}
	public void setParkingInfo(String parkingInfo) {
		this.parkingInfo = parkingInfo;
	}
	@JsonSerialize(using=DateTimeISO8601Serializer.class)
	public Date getCreateDttm() {
		return createDttm;
	}
	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}
	@JsonSerialize(using=DateTimeISO8601Serializer.class)
	public Date getLastUpdateDttm() {
		return lastUpdateDttm;
	}
	public void setLastUpdateDttm(Date lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}
	
	

}
