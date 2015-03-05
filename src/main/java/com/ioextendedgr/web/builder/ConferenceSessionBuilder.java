package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.ConferenceSession;
import com.ioextendedgr.web.data.ConferenceSessionPresenter;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;
import com.ioextendedgr.web.viewDto.ConferenceView;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by Scott Williams on 3/4/2015.
 */
public class ConferenceSessionBuilder {

    public static List<ConferenceSessionView> build(Collection<ConferenceSession> datas) {
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
        for(ConferenceSessionPresenter csp: data.getConferenceSessionPresenters()){
            cspIds.add(csp.getId());
        }
        view.setPresenterIds(new ArrayList<>(cspIds));
        view.setRoomId(data.getRoom().getId());
        view.setStartDttm(data.getStartDttm());

        return view;
    }



    }
