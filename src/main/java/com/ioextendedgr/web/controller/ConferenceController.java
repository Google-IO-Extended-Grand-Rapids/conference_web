package com.ioextendedgr.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.service.ConferenceService;
import com.ioextendedgr.web.viewDto.ConferenceView;

@RestController
@RequestMapping("/api")
public class ConferenceController {
	
	@Autowired
	private ConferenceService conferenceService;

    @RequestMapping("/conference")
    public Collection<ConferenceView> findAllConferences() {
    	return conferenceService.findAllConferences();
    }

    @RequestMapping("/conference/{id}")
    public ConferenceView findAllConferencesById(@PathVariable("id") Long id) {
    	return conferenceService.findAllConferencesById(id);
    }

	
}
