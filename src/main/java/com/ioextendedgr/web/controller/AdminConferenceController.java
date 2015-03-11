package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Conference;
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
@RequestMapping("/admin/conference")
public class AdminConferenceController {

    private static final Logger logger = LoggerFactory.getLogger(AdminConferenceController.class);

    public static String CONFERENCE_VIEW = "conference";

    @Autowired
    private ConferenceService conferenceService;


    @RequestMapping(method = RequestMethod.GET)
    public String getConferenceView(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());
        model.addAttribute("locations", conferenceService.findAllLocations());
        return CONFERENCE_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addConference(Conference conference, BindingResult result, @RequestParam Map<String,String> params) {

        logger.info("PARAMS:\n\n\n " + params.toString());
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addConference(conference);
        return "redirect:" + CONFERENCE_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteConference(@RequestParam Integer id) {

        conferenceService.deleteConference(id);
        return "redirect:" + CONFERENCE_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateConference(Conference conference, BindingResult result) {
        conferenceService.updateConference(conference);
        return "redirect:" + CONFERENCE_VIEW;
    }


    @InitBinder
    public void binder(WebDataBinder binder) {binder.registerCustomEditor(Timestamp.class,
            new PropertyEditorSupport() {
                public void setAsText(String value) {
                    try {
                        Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        setValue(new Timestamp(parsedDate.getTime()));
                    } catch (ParseException e) {
                        setValue(null);
                    }
                }
            });
    }
}
