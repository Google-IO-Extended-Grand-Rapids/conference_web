package com.ioextendedgr.web.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.Location;
import com.ioextendedgr.web.viewDto.ConferenceView;
import com.ioextendedgr.web.viewDto.LocationView;

public class ConferenceViewBuilder {

	public static List<ConferenceView> build(Collection<Conference> datas) {

		if (CollectionUtils.isEmpty(datas)) {
			return new ArrayList<ConferenceView>();
		}

		List<ConferenceView> views = new ArrayList<ConferenceView>();

		for (Conference data : datas) {
			views.add(build(data));
		}

		return views;
	}

	public static ConferenceView build(Conference data) {
		if (data == null)
			return null;
		
		ConferenceView view = new ConferenceView();
		
		view.setId(Long.valueOf(data.getId()));

		view.setName(data.getName());
		view.setStartDate(data.getStartDate());
		view.setEndDate(data.getEndDate());
		view.setShortDesc(data.getShortDesc());
		view.setFullDesc(data.getFullDesc());

		view.setCreateDttm(data.getCreateDttm());
		view.setLastUpdateDttm(data.getLastUpdateDttm());

		view.setLocationView(toLocationView(data.getLocation()));

		return view;
	}

	private static LocationView toLocationView(Location data) {
		LocationView view = new LocationView();

		view.setId(data.getId());

		view.setName(data.getName());
		view.setShortDesc(data.getShortDesc());
		view.setFullDesc(data.getFullDesc());
		view.setParkingInfo(data.getParkingInfo());

		view.setCreateDttm(data.getCreateDttm());

		return view;
	}

}
