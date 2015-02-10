package com.ioextendedgr.web.viewDto;

public class PresenterView {

	private Long id;
	private String userId;
	private String shortBio;
	private String jobTitle;
	private CompanyView companyView;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
