package com.ioextendedgr.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.service.ConferenceService;
import com.ioextendedgr.web.viewDto.PresenterView;

@RestController
@RequestMapping("/api")
public class PresenterController {

	@Autowired
	private ConferenceService conferenceService;

    @RequestMapping("/presenter")
    public Collection<PresenterView> findAllPresenters() {
    	return conferenceService.findAllPresenters();
    }

    @RequestMapping("/presenter/{id}")
    public PresenterView findPresenterById(@PathVariable("id") Integer id) {
    	return conferenceService.findPresenterById(id);
    }
}
