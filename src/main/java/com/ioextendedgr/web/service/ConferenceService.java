package com.ioextendedgr.web.service;

import java.util.Collection;

import com.ioextendedgr.web.builder.ConferenceSessionBuilder;
import com.ioextendedgr.web.repository.ConferenceSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ioextendedgr.web.builder.ConferenceViewBuilder;
import com.ioextendedgr.web.repository.ConferenceRepository;
import com.ioextendedgr.web.util.StubFactory;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;
import com.ioextendedgr.web.viewDto.ConferenceView;
import com.ioextendedgr.web.viewDto.PresenterView;

@Component
public class ConferenceService {
	
	@Autowired
	private StubFactory stubFactory;
	
	@Autowired
	private ConferenceRepository conferenceRepository;

    @Autowired
    private ConferenceSessionRepository conferenceSessionRepository;

	public Collection<ConferenceView> findAllConferences() {
		return ConferenceViewBuilder.build(conferenceRepository.findAll());
	}

	public ConferenceView findConferenceById(Integer id) {
		return ConferenceViewBuilder.build(conferenceRepository.findOne(id));
	}

	public Collection<PresenterView> findAllPresenters() {
		return stubFactory.findAllPresenters();
	}

	public PresenterView findPresenterById(Long id) {
		return stubFactory.findPresenterById(id);
	}

	public Collection<ConferenceSessionView> findAllConferenceSessions() {
        return ConferenceSessionBuilder.build(conferenceSessionRepository.findAll());
	}

	public ConferenceSessionView findConferenceSessionById(Integer id) {
        return ConferenceSessionBuilder.build(conferenceSessionRepository.findOne(id));
	}

	public Collection<ConferenceSessionView> findConferenceSessionsByConferenceId(Integer id) {
		return ConferenceSessionBuilder.build(conferenceSessionRepository.findByConferenceId(id));
	}

}
