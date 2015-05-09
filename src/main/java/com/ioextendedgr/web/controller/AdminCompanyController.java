package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/company")
public class AdminCompanyController {

    private static final Logger logger = LoggerFactory.getLogger(AdminCompanyController.class);

    public static final String COMPANY_VIEW = "company";

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCompanyView(ModelMap model) {
        model.addAttribute("companies", conferenceService.findAllCompanies());
        return COMPANY_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCompany(Company company, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addCompany(company);
        return "redirect:" + COMPANY_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteCompany(@RequestParam Integer id) {
        conferenceService.deleteCompany(id);
        return "redirect:" + COMPANY_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateCompany(Company company, BindingResult result) {
        conferenceService.updateCompany(company);
        return "redirect:" + COMPANY_VIEW;
    }

}
