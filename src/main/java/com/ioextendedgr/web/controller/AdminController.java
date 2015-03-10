package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static String CONFERENCE_VIEW = "conference";

    @Autowired
    private ConferenceService conferenceService;


    @RequestMapping(value = "/conference")
    public String getConferenceView(ModelMap model) {
        //Collection<ConferenceView> conferenceViews = conferenceService.findAllConferences();
        model.addAttribute("conferences", conferenceService.findAllConferences());

        return CONFERENCE_VIEW;
    }
}
