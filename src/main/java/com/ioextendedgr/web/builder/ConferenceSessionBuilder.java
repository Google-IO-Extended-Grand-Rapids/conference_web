package com.ioextendedgr.web.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.ioextendedgr.web.data.ConferenceSession;
import com.ioextendedgr.web.data.ConferenceSessionPresenter;
import com.ioextendedgr.web.data.ConferenceSessionType;
import com.ioextendedgr.web.viewDto.ConferenceSessionTypeView;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;

/**
 * Created by Scott Williams on 3/4/2015.
 */
public class ConferenceSessionBuilder {

	public static List<ConferenceSessionView> build(
			Collection<ConferenceSession> datas) {
		if (CollectionUtils.isEmpty(datas)) {
			return new ArrayList<>();
		}

		List<ConferenceSessionView> views = new ArrayList<>();
		for (ConferenceSession data : datas) {
			views.add(build(data));
		}
		return views;
	}

	public static ConferenceSessionView build(ConferenceSession data) {
		if (data == null)
			return null;

		ConferenceSessionView view = new ConferenceSessionView();

		view.setId(data.getId());
		view.setName(data.getName());
		view.setConferenceId(data.getConference().getId());
		view.setDurationMinutes(data.getDuration());
		view.setShortDesc(data.getShortDesc());
		view.setFullDesc(data.getFullDesc());
		view.setCreateDttm(data.getCreateDttm());
		view.setLastUpdateDttm(data.getLastUpdateDttm());
		Set<Integer> cspIds = new HashSet<>();
		for (ConferenceSessionPresenter csp : data
				.getConferenceSessionPresenters()) {
			cspIds.add(csp.getPresenter().getId());
		}

		view.setConferenceSessionType(toConferenceSessionTypeView(data
				.getConferenceSessionType()));

		view.setPresenterIds(new ArrayList<>(cspIds));
		view.setRoomId(data.getRoom().getId());
		view.setStartDttm(data.getStartDttm());

		return view;
	}

	private static ConferenceSessionTypeView toConferenceSessionTypeView(
			ConferenceSessionType conferenceSessionType) {

		if (conferenceSessionType == null) {
			return toDefaultConferenceSessionTypeView();
		}
		ConferenceSessionTypeView confSessionTypeView = new ConferenceSessionTypeView();

		confSessionTypeView.setId(conferenceSessionType.getId());
		confSessionTypeView.setName(conferenceSessionType.getName());
		confSessionTypeView.setDescription(conferenceSessionType.getDesc());
		return confSessionTypeView;
	}

	private static ConferenceSessionTypeView toDefaultConferenceSessionTypeView() {
		ConferenceSessionTypeView confSessionTypeView = new ConferenceSessionTypeView();

		confSessionTypeView.setId(6);
		confSessionTypeView.setName("Onsite");
		confSessionTypeView.setDescription("Onsite");

		return confSessionTypeView;
	}

}
