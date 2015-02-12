package com.ioextendedgr.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.service.ConferenceService;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;

@RestController
@RequestMapping("/api")
public class ConferenceSessionController {

	@Autowired
	private ConferenceService conferenceService;

    @RequestMapping("/conferenceSession")
    public Collection<ConferenceSessionView> findAllConferenceSessions() {
    	return conferenceService.findAllConferenceSessions();
    }

    @RequestMapping("/conferenceSession/{id}")
    public ConferenceSessionView findConferenceSessionById(@PathVariable("id") Long id) {
    	return conferenceService.findConferenceSessionById(id);
    }
}
