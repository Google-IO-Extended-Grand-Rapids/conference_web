package com.ioextendedgr.web.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ioextendedgr.web.viewDto.ConferenceView;
import com.ioextendedgr.web.viewDto.LocationView;

@Component
public class StubFactory {
	
	Map<Long, ConferenceView> conferenceViewsByIdMap = new HashMap<Long, ConferenceView>();
	public StubFactory() {
		init();
	}

	public Collection<ConferenceView> findAllConferences() {
		return conferenceViewsByIdMap.values();
	}
	private void init() {
		List<ConferenceView> createConferenceViews = createConferenceViews();
		for (ConferenceView currConferenceView : createConferenceViews) {
			conferenceViewsByIdMap.put(currConferenceView.getId(), currConferenceView);
		}
	}

	public ConferenceView findConferenceById(Long id) {
		return conferenceViewsByIdMap.get(id);
	}

	public static List<ConferenceView> createConferenceViews() {
		int conferenceListSize = 10;
		List<ConferenceView> conferenceList = new ArrayList<ConferenceView>();
		
		for (int i = 0; i < conferenceListSize; i++) {
			conferenceList.add(toConferenceView(i));
		}
		
		return conferenceList;
		
	}

	private static ConferenceView toConferenceView(int index) {
		
		ConferenceView conferenceView = new ConferenceView();
		conferenceView.setCreateDttm(new Date());
		conferenceView.setEndDate(new Date());
		conferenceView.setFullDesc(String.format("Conference: %d The complete full description in all of it's glory", index));
		conferenceView.setId(Long.valueOf(index));
		conferenceView.setLastUpdateDttm(new Date());
		conferenceView.setLocationView(toLocationView(index));
		conferenceView.setName(String.format("Conference %d", index));
		conferenceView.setShortDesc(String.format("Conf %d short desc", index));
		conferenceView.setStartDate(new Date());
		
		return conferenceView;
	}

	private static LocationView toLocationView(int index) {
		LocationView dto = new LocationView();
		
		dto.setCreateDttm(new Date());
		dto.setFullDesc(String.format("Full Description Location: %d", index));
		dto.setId(Long.valueOf(index));
		dto.setLastUpdateDttm(new Date());
		dto.setName(String.format("Location %d", index));
		dto.setParkingInfo(String.format("The parking information for Location: %d is the following....", index));
		dto.setShortDesc(String.format("Location: %d", index));
		
		return dto;
	}

}
