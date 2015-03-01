package com.ioextendedgr.web.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="full_desc")
	private String fullDesc;

	@Column(name="logo_path")
	private String logoPath;

	private String name;

	@Column(name="short_desc")
	private String shortDesc;

	//bi-directional many-to-one association to Presenter
	@OneToMany(mappedBy="company")
	private List<Presenter> presenters;

	public Company() {
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

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public List<Presenter> getPresenters() {
		return this.presenters;
	}

	public void setPresenters(List<Presenter> presenters) {
		this.presenters = presenters;
	}

	public Presenter addPresenter(Presenter presenter) {
		getPresenters().add(presenter);
		presenter.setCompany(this);

		return presenter;
	}

	public Presenter removePresenter(Presenter presenter) {
		getPresenters().remove(presenter);
		presenter.setCompany(null);

		return presenter;
	}

}