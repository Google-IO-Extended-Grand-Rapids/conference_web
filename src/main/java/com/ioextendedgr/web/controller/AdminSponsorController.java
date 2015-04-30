package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.Sponsor;
import com.ioextendedgr.web.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/sponsor")
public class AdminSponsorController {

    private static final Logger logger = LoggerFactory.getLogger(AdminSponsorController.class);

    public static final String SPONSOR_VIEW = "sponsor";

    @Autowired
    private ConferenceService conferenceService;


    @RequestMapping(method = RequestMethod.GET)
    public String getSponsorView(ModelMap model) {
        model.addAttribute("sponsors", conferenceService.findAllSponsors());
        model.addAttribute("sponsorLevels", conferenceService.findAllSponsorLevels());
        return SPONSOR_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSponsor(Sponsor sponsor, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addSponsor(sponsor);
        return "redirect:" + SPONSOR_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteSponsor(@RequestParam Integer id) {
        conferenceService.deleteSponsor(id);
        return "redirect:" + SPONSOR_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateSponsor(Sponsor sponsor, BindingResult result) {
        conferenceService.updateSponsor(sponsor);
        return "redirect:" + SPONSOR_VIEW;
    }

}
