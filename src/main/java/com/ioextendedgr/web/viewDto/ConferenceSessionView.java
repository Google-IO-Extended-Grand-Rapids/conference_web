package com.ioextendedgr.web.viewDto;

import java.util.Date;
import java.util.List;

public class ConferenceSessionView {

	private Long id;
	private String name;
	private String shortDesc;
	private String fullDesc;
	private Long conferenceId;
	private List<Long> presenterIds;
	private Long roomId;
	private Date startDttm;
	private Integer durationMinutes;
	private Date createDttm;
	private Date lastUpdateDttm;
	
	
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
	public Long getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(Long conferenceId) {
		this.conferenceId = conferenceId;
	}
	public List<Long> getPresenterIds() {
		return presenterIds;
	}
	public void setPresenterIds(List<Long> presenterIds) {
		this.presenterIds = presenterIds;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
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
	
	
}
