package com.ioextendedgr.web.viewDto;

public class PresenterView {

	private Integer id;
	private Integer userId;
	private String shortBio;
	private String jobTitle;
	private CompanyView companyView;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getShortBio() {
		return shortBio;
	}
	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public CompanyView getCompanyView() {
		return companyView;
	}
	public void setCompanyView(CompanyView companyView) {
		this.companyView = companyView;
	}
	
	
}
