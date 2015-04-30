package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Presenter;
import com.ioextendedgr.web.data.Sponsor;
import com.ioextendedgr.web.viewDto.PresenterView;
import com.ioextendedgr.web.viewDto.SponsorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SponsorBuilder {

	public static Collection<SponsorView> build(Collection<Sponsor> dtos) {
		List<SponsorView> sponsors = new ArrayList<>();
		
		for (Sponsor sponsor : dtos) {
            sponsors.add(build(sponsor));
		}
		
		return sponsors;
	}
	
	public static SponsorView build(Sponsor dto) {
        SponsorView sponsor = new SponsorView();
		
        sponsor.setId(dto.getId());
        sponsor.setHomePageUrl(dto.getHomePageUrl());
        sponsor.setLogoPath(dto.getLogoPath());
        sponsor.setName(dto.getName());
        if(dto.getSponsorLevelBean() != null) {
            sponsor.setSponsorLevelDesc(dto.getSponsorLevelBean().getFullDesc());
        }

		return sponsor;
	}

}
