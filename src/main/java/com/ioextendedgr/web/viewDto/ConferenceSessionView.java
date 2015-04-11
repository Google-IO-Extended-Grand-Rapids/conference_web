package com.ioextendedgr.web.viewDto;

import java.util.Date;
import java.util.List;

public class ConferenceSessionView {

	private Integer id;
	private String name;
	private String shortDesc;
	private String fullDesc;
	private Integer conferenceId;
	private List<Integer> presenterIds;
	private Integer roomId;
	private Date startDttm;
	private Integer durationMinutes;
	private ConferenceSessionTypeView conferenceSessionType;
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
	public Integer getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(Integer conferenceId) {
		this.conferenceId = conferenceId;
	}
	public List<Integer> getPresenterIds() {
		return presenterIds;
	}
	public void setPresenterIds(List<Integer> presenterIds) {
		this.presenterIds = presenterIds;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Date getStartDttm() {
		return startDttm;
	}
	public void setStartDttm(Date startDttm) {
		this.startDttm = startDttm;
	}
	public Integer getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	public Date getCreateDttm() {
		return createDttm;
	}
	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}
	public Date getLastUpdateDttm() {
		return lastUpdateDttm;
	}
	public void setLastUpdateDttm(Date lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}
	public ConferenceSessionTypeView getConferenceSessionType() {
		return conferenceSessionType;
	}
	public void setConferenceSessionType(ConferenceSessionTypeView conferenceSessionType) {
		this.conferenceSessionType = conferenceSessionType;
	}
	
	
}
