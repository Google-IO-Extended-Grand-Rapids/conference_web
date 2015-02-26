package com.ioextendedgr.web.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sponsor_level database table.
 * 
 */
@Entity
@Table(name="sponsor_level")
public class SponsorLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="full_desc")
	private String fullDesc;

	//bi-directional many-to-one association to Sponsor
	@OneToMany(mappedBy="sponsorLevelBean")
	private List<Sponsor> sponsors;

	//bi-directional many-to-one association to Conference
	@ManyToOne
	private Conference conference;

	public SponsorLevel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullDesc() {
		return this.fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public List<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Sponsor addSponsor(Sponsor sponsor) {
		getSponsors().add(sponsor);
		sponsor.setSponsorLevelBean(this);

		return sponsor;
	}

	public Sponsor removeSponsor(Sponsor sponsor) {
		getSponsors().remove(sponsor);
		sponsor.setSponsorLevelBean(null);

		return sponsor;
	}

	public Conference getConference() {
		return this.conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

}