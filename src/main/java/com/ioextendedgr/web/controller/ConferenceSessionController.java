package com.ioextendedgr.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.service.ConferenceService;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;

@RestController
@RequestMapping("/api/conferenceSession")
public class ConferenceSessionController {

	@Autowired
	private ConferenceService conferenceService;

    @RequestMapping("")
    public Collection<ConferenceSessionView> findAllConferenceSessions() {
    	return conferenceService.findAllConferenceSessions();
    }

    @RequestMapping("/{id}")
    public ConferenceSessionView findConferenceSessionById(@PathVariable("id") Integer id) {
    	return conferenceService.findConferenceSessionById(id);
    }
}
