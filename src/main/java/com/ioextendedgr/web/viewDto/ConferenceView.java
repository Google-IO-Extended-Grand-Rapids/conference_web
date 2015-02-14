package com.ioextendedgr.web.viewDto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ioextendedgr.web.util.DateTimeISO8601Serializer;

public class ConferenceView {
	
	private Long id;
	private String name;
	private String shortDesc;
	private String fullDesc;
	private Date startDate;
	private Date endDate;
	private Date createDttm;
	private Date lastUpdateDttm;
	private LocationView locationView;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	@JsonSerialize(using=DateTimeISO8601Serializer.class)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@JsonSerialize(using=DateTimeISO8601Serializer.class)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public LocationView getLocationView() {
		return locationView;
	}
	public void setLocationView(LocationView locationView) {
		this.locationView = locationView;
	}

}
