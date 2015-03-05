package com.ioextendedgr.web.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.data.Presenter;
import com.ioextendedgr.web.viewDto.CompanyView;
import com.ioextendedgr.web.viewDto.PresenterView;

public class PresenterBuilder {

	public static Collection<PresenterView> build(Collection<Presenter> dtos) {
		List<PresenterView> presenters = new ArrayList<PresenterView>();
		
		for (Presenter currPresenter : dtos) {
			presenters.add(build(currPresenter));
		}
		
		return presenters;
	}
	
	public static PresenterView build(Presenter dto) {
		PresenterView presenter = new PresenterView();
		
		presenter.setCompanyView(toCompanyView(dto.getCompany()));
		presenter.setId(dto.getId());
		presenter.setJobTitle(dto.getJobTitle());
		presenter.setShortBio(dto.getShortBio());
		presenter.setUserId(dto.getUserId());
		
		return presenter;
	}

	private static CompanyView toCompanyView(Company dto) {
		CompanyView companyView = new CompanyView();
		
		companyView.setFullDesc(dto.getFullDesc());
		companyView.setId(dto.getId());
		companyView.setLogoPath(dto.getLogoPath());
		companyView.setName(dto.getName());
		companyView.setShortDesc(dto.getShortDesc());
		
		return companyView;
	}
	
}
