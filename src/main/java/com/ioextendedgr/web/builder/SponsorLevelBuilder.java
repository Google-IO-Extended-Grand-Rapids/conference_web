package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.SponsorLevel;
import com.ioextendedgr.web.viewDto.SponsorLevelView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SponsorLevelBuilder {

	public static Collection<SponsorLevelView> build(Collection<SponsorLevel> dtos) {
		List<SponsorLevelView> sponsorLevelViews = new ArrayList<>();
		
		for (SponsorLevel sponsorLevel : dtos) {
            sponsorLevelViews.add(build(sponsorLevel));
		}
		
		return sponsorLevelViews;
	}
	
	public static SponsorLevelView build(SponsorLevel dto) {
        SponsorLevelView sponsorLevelView = new SponsorLevelView();

        sponsorLevelView.setId(dto.getId());
        sponsorLevelView.setFullDesc(dto.getFullDesc());

        if(dto.getConference() != null) {
            sponsorLevelView.setConferenceName(dto.getConference().getName());
        }

		return sponsorLevelView;
	}

}
