package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the presenter database table.
 * 
 */
@Entity
@Table(name="presenter")
public class Presenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="short_bio")
	private String shortBio;

	@Column(name="user_id")
	private Long userId;

	//bi-directional many-to-one association to ConferenceSessionPresenter
	@OneToMany(mappedBy="presenter")
	private List<ConferenceSessionPresenter> conferenceSessionPresenters;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_affiliation_id")
	private Company company;

	public Presenter() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getShortBio() {
		return this.shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ConferenceSessionPresenter> getConferenceSessionPresenters() {
		return this.conferenceSessionPresenters;
	}

	public void setConferenceSessionPresenters(List<ConferenceSessionPresenter> conferenceSessionPresenters) {
		this.conferenceSessionPresenters = conferenceSessionPresenters;
	}

	public ConferenceSessionPresenter addConferenceSessionPresenter(ConferenceSessionPresenter conferenceSessionPresenter) {
		getConferenceSessionPresenters().add(conferenceSessionPresenter);
		conferenceSessionPresenter.setPresenter(this);

		return conferenceSessionPresenter;
	}

	public ConferenceSessionPresenter removeConferenceSessionPresenter(ConferenceSessionPresenter conferenceSessionPresenter) {
		getConferenceSessionPresenters().remove(conferenceSessionPresenter);
		conferenceSessionPresenter.setPresenter(null);

		return conferenceSessionPresenter;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}