package com.ioextendedgr.web.data;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the sponsor database table.
 * 
 */
@Entity
@Table(name="sponsor")
public class Sponsor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="home_page_url")
	private String homePageUrl;

	@Column(name="logo_path")
	private String logoPath;

	private String name;

	//bi-directional many-to-one association to SponsorLevel
	@ManyToOne
	@JoinColumn(name="sponsor_level")
	private SponsorLevel sponsorLevel;

	public Sponsor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomePageUrl() {
		return this.homePageUrl;
	}

	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SponsorLevel getSponsorLevelBean() {
		return this.sponsorLevel;
	}

	public void setSponsorLevelBean(SponsorLevel sponsorLevelBean) {
		this.sponsorLevel = sponsorLevelBean;
	}

}