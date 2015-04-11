package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.ConferenceSession;
import com.ioextendedgr.web.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin/conference_session")
public class AdminConferenceSessionController {

    private static final Logger logger = LoggerFactory.getLogger(AdminConferenceSessionController.class);

    public static final String CONFERENCE_SESSION_VIEW = "conference_session";

    @Autowired
    private ConferenceService conferenceService;


    @RequestMapping(method = RequestMethod.GET)
    public String getConferenceSessionView(ModelMap model) {
        model.addAttribute("conferenceSessions", conferenceService.findAllConferenceSessions());
        model.addAttribute("conferences", conferenceService.findAllConferences());
        model.addAttribute("rooms", conferenceService.findAllRooms());
        return CONFERENCE_SESSION_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addConference(ConferenceSession conferenceSession, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addConferenceSession(conferenceSession);
        return "redirect:" + CONFERENCE_SESSION_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteConference(@RequestParam Integer id) {
        conferenceService.deleteConferenceSession(id);
        return "redirect:" + CONFERENCE_SESSION_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateConference(ConferenceSession conferenceSession, BindingResult result) {
        conferenceService.updateConferenceSession(conferenceSession);
        return "redirect:" + CONFERENCE_SESSION_VIEW;
    }

    @InitBinder
    public void binder(WebDataBinder binder) {binder.registerCustomEditor(Timestamp.class,
            new PropertyEditorSupport() {
                public void setAsText(String value) {
                    try {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd kk:mm").parse(value);
                        setValue(new Timestamp(parsedDate.getTime()));
                    } catch (ParseException e) {
                        setValue(null);
                    }
                }
            });
    }
}
