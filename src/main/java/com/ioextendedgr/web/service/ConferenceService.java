package com.ioextendedgr.web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.ioextendedgr.web.builder.ConferenceSessionBuilder;
import com.ioextendedgr.web.builder.ConferenceViewBuilder;
import com.ioextendedgr.web.builder.LocationBuilder;
import com.ioextendedgr.web.builder.PresenterBuilder;
import com.ioextendedgr.web.builder.RoomViewBuilder;
import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.Location;
import com.ioextendedgr.web.repository.ConferenceRepository;
import com.ioextendedgr.web.repository.ConferenceSessionRepository;
import com.ioextendedgr.web.repository.LocationRepository;
import com.ioextendedgr.web.repository.PresenterRepository;
import com.ioextendedgr.web.repository.RoomRepository;
import com.ioextendedgr.web.util.StubFactory;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;
import com.ioextendedgr.web.viewDto.ConferenceView;
import com.ioextendedgr.web.viewDto.LocationView;
import com.ioextendedgr.web.viewDto.PresenterView;
import com.ioextendedgr.web.viewDto.RoomView;

@Component
public class ConferenceService {

	@Autowired
	private StubFactory stubFactory;

	@Autowired
	private ConferenceRepository conferenceRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ConferenceSessionRepository conferenceSessionRepository;

	@Autowired
	private RoomRepository roomRepository;

    @Autowired
    private PresenterRepository presenterRepository;

	public Collection<ConferenceView> findAllConferences() {
		return ConferenceViewBuilder.build(conferenceRepository.findAll());
	}

	public ConferenceView findConferenceById(Integer id) {
		return ConferenceViewBuilder.build(conferenceRepository.findOne(id));
	}

	public Collection<PresenterView> findAllPresenters() {
		return PresenterBuilder.build(presenterRepository.findAll());
	}

	public PresenterView findPresenterById(Integer id) {
		return PresenterBuilder.build(presenterRepository.findOne(id));
	}

	public Collection<ConferenceSessionView> findAllConferenceSessions() {
		return ConferenceSessionBuilder.build(conferenceSessionRepository
				.findAll());
	}

    public Collection<LocationView> findAllLocations() {
        return LocationBuilder.build(locationRepository.findAll());
    }

	public ConferenceSessionView findConferenceSessionById(Integer id) {
		return ConferenceSessionBuilder.build(conferenceSessionRepository
				.findOne(id));
	}

	public Collection<ConferenceSessionView> findConferenceSessionsByConferenceId(
			Integer id) {
		return ConferenceSessionBuilder.build(conferenceSessionRepository
				.findByConferenceId(id));
	}

    public void addConference(Conference conference){
          conferenceRepository.save(conference);
    }

    public void deleteConference(Integer id){
        conferenceRepository.delete(id);
    }

    public void updateConference(Conference inputConference){
        Conference managedConference =conferenceRepository.findOne(inputConference.getId());
        if(!Strings.isNullOrEmpty(inputConference.getName())){
            managedConference.setName(inputConference.getName());
        }

        if(!Strings.isNullOrEmpty(inputConference.getShortDesc())){
            managedConference.setShortDesc(inputConference.getShortDesc());
        }

        if(!Strings.isNullOrEmpty(inputConference.getFullDesc())){
            managedConference.setFullDesc(inputConference.getFullDesc());
        }

        if(inputConference.getStartDate() != null){
            managedConference.setStartDate(inputConference.getStartDate());
        }

        if(inputConference.getEndDate() != null){
            managedConference.setEndDate(inputConference.getEndDate());
        }

        if(inputConference.getLocation() != null){
            Location location = new Location();
            location.setId(inputConference.getLocation().getId());
            managedConference.setLocation(location);
        }

        conferenceRepository.save(managedConference);
    }



	public RoomView findRoomById(Integer id) {
		return RoomViewBuilder.build(roomRepository.findOne(id));
	}
}
