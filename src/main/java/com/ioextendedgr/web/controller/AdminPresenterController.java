package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.Presenter;
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
@RequestMapping("/admin/presenter")
public class AdminPresenterController {

    private static final Logger logger = LoggerFactory.getLogger(AdminPresenterController.class);

    public static final String PRESENTER_VIEW = "presenter";

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPresenterView(ModelMap model) {
        model.addAttribute("presenters", conferenceService.findAllPresenters());
        model.addAttribute("companies", conferenceService.findAllCompanies());
        return PRESENTER_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPresenter(Presenter presenter, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addPresenter(presenter);
        return "redirect:" + PRESENTER_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deletePresenter(@RequestParam Integer id) {
        conferenceService.deletePresenter(id);
        return "redirect:" + PRESENTER_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updatePresenter(Presenter presenter, BindingResult result) {
        conferenceService.updatePresenter(presenter);
        return "redirect:" + PRESENTER_VIEW;
    }

}
