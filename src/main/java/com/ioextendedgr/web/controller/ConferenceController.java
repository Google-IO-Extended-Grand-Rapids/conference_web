package com.ioextendedgr.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.util.StubFactory;
import com.ioextendedgr.web.viewDto.ConferenceView;

@RestController
public class ConferenceController {

    @RequestMapping("/conference")
    public List<ConferenceView> findAllConferences() {
    	return StubFactory.createConferenceViews();
    }

	
}
