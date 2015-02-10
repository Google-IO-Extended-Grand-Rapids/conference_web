package com.ioextendedgr.web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ioextendedgr.web.util.StubFactory;
import com.ioextendedgr.web.viewDto.ConferenceView;

@Component
public class ConferenceService {
	
	@Autowired
	private StubFactory stubFactory;

	public Collection<ConferenceView> findAllConferences() {
		return stubFactory.findAllConferences();
	}

	public ConferenceView findAllConferencesById(Long id) {
		return stubFactory.findConferenceById(id);
	}

}
