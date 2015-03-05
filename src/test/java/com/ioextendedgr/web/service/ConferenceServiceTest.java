package com.ioextendedgr.web.service;

import base.BaseSpringIT;
import com.ioextendedgr.web.repository.ConferenceRepository;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;
import com.ioextendedgr.web.viewDto.ConferenceView;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class ConferenceServiceTest extends BaseSpringIT{

    private static Logger logger = LoggerFactory.getLogger(ConferenceServiceTest.class);

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Before
    public void setup(){
        //Can't get the boot log levels turned down...
        logger.info("\n\n\n\n\n\n\n\n");
    }

    @After
    public void teardown(){
        logger.info("\n\n\n\n\n\n\n\n");
    }

    @Test
    public void testConference(){
        logger.info("{}", conferenceRepository.findAll().size());
        List<ConferenceView> conferenceViews = new ArrayList<>(conferenceService.findAllConferences());
    }

    @Test
    public void testConferenceSession(){
        List<ConferenceView> conferenceViews = new ArrayList<>(conferenceService.findAllConferences());

        List<ConferenceSessionView> conferenceSessionViews = new ArrayList<>(conferenceService.findAllConferenceSessions());

        ConferenceSessionView cv1 = conferenceService.findConferenceSessionById(conferenceSessionViews.get(0).getId());

        ConferenceSessionView cv2 =  new ArrayList<>(conferenceService.findConferenceSessionsByConferenceId(conferenceViews.get(0).getId().intValue())).get(0);

        logger.info("");

    }


}
