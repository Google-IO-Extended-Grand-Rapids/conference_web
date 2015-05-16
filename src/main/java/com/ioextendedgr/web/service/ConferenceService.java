package com.ioextendedgr.web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.ioextendedgr.web.builder.CompanyBuilder;
import com.ioextendedgr.web.builder.ConferenceSessionBuilder;
import com.ioextendedgr.web.builder.ConferenceViewBuilder;
import com.ioextendedgr.web.builder.LocationBuilder;
import com.ioextendedgr.web.builder.PresenterBuilder;
import com.ioextendedgr.web.builder.RoomViewBuilder;
import com.ioextendedgr.web.builder.SponsorBuilder;
import com.ioextendedgr.web.builder.SponsorLevelBuilder;
import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.ConferenceSession;
import com.ioextendedgr.web.data.Presenter;
import com.ioextendedgr.web.data.Room;
import com.ioextendedgr.web.data.Sponsor;
import com.ioextendedgr.web.data.SponsorLevel;
import com.ioextendedgr.web.data.User;
import com.ioextendedgr.web.repository.CompanyRepository;
import com.ioextendedgr.web.repository.ConferenceRepository;
import com.ioextendedgr.web.repository.ConferenceSessionRepository;
import com.ioextendedgr.web.repository.LocationRepository;
import com.ioextendedgr.web.repository.PresenterRepository;
import com.ioextendedgr.web.repository.RoomRepository;
import com.ioextendedgr.web.repository.SponsorLevelRepository;
import com.ioextendedgr.web.repository.SponsorRepository;
import com.ioextendedgr.web.repository.UserRepository;
import com.ioextendedgr.web.util.StubFactory;
import com.ioextendedgr.web.viewDto.CompanyView;
import com.ioextendedgr.web.viewDto.ConferenceSessionView;
import com.ioextendedgr.web.viewDto.ConferenceView;
import com.ioextendedgr.web.viewDto.LocationView;
import com.ioextendedgr.web.viewDto.PresenterView;
import com.ioextendedgr.web.viewDto.RoomView;
import com.ioextendedgr.web.viewDto.SponsorLevelView;
import com.ioextendedgr.web.viewDto.SponsorView;

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

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private SponsorRepository sponsorRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SponsorLevelRepository sponsorLevelRepository;

	public Collection<CompanyView> findAllCompanies() {
		return CompanyBuilder.build(companyRepository.findAll());
	}

	public CompanyView findCompanyById(Integer id) {
		return CompanyBuilder.build(companyRepository.findOne(id));
	}

	public void deleteCompany(Integer id) {
		companyRepository.delete(id);
	}

	public void updateCompany(Company inputCompany) {
		Company managedCompany = companyRepository
				.findOne(inputCompany.getId());

		if (!Strings.isNullOrEmpty(inputCompany.getName())) {
			managedCompany.setName(inputCompany.getName());
		}
		if (!Strings.isNullOrEmpty(inputCompany.getShortDesc())) {
			managedCompany.setShortDesc(inputCompany.getShortDesc());
		}
		if (!Strings.isNullOrEmpty(inputCompany.getFullDesc())) {
			managedCompany.setFullDesc(inputCompany.getFullDesc());
		}
		if (!Strings.isNullOrEmpty(inputCompany.getLogoPath())) {
			managedCompany.setLogoPath(inputCompany.getLogoPath());
		}
		companyRepository.save(managedCompany);
	}

	public void addCompany(Company company) {
		companyRepository.save(company);
	}

	public Collection<ConferenceView> findAllConferences() {
		return ConferenceViewBuilder.build(conferenceRepository.findAll());
	}

	public ConferenceView findConferenceById(Integer id) {
		return ConferenceViewBuilder.build(conferenceRepository.findOne(id));
	}

	public Collection<PresenterView> findAllPresenters() {
		return PresenterBuilder.build(presenterRepository.findAll(),
				userRepository.findAll());
	}

	public PresenterView findPresenterById(Integer id) {
		Presenter presenter = presenterRepository.findOne(id);

		if (presenter == null) {
			return null;
		}

		User user = null;
		if (presenter.getUserId() != null) {
			user = userRepository.findOne(presenter.getUserId());
		}
		return PresenterBuilder.build(presenter, user);
	}

	public void deletePresenter(Integer id) {
		presenterRepository.delete(id);
	}

	public void addPresenter(Presenter presenter) {
		presenterRepository.save(presenter);
	}

	public void updatePresenter(Presenter inputPresenter) {
		Presenter managedPresenter = presenterRepository.findOne(inputPresenter
				.getId());
		if (inputPresenter.getCompany() != null
				&& inputPresenter.getCompany().getId() != null) {
			managedPresenter.setCompany(inputPresenter.getCompany());
		}
		if (inputPresenter.getUserId() != null) {
			managedPresenter.setUserId(inputPresenter.getUserId());
		}
		if (!Strings.isNullOrEmpty(inputPresenter.getJobTitle())) {
			managedPresenter.setJobTitle(inputPresenter.getJobTitle());
		}
		if (!Strings.isNullOrEmpty(inputPresenter.getShortBio())) {
			managedPresenter.setShortBio(inputPresenter.getShortBio());
		}
		presenterRepository.save(managedPresenter);
	}

	public Collection<ConferenceSessionView> findAllConferenceSessions() {
		return ConferenceSessionBuilder.build(conferenceSessionRepository
				.findAll());
	}

	public void addConferenceSession(ConferenceSession conferenceSession) {
		conferenceSessionRepository.save(conferenceSession);
	}

	public void updateConferenceSession(ConferenceSession inputConferenceSession) {
		ConferenceSession managedConferenceSession = conferenceSessionRepository
				.findOne(inputConferenceSession.getId());

		if (!Strings.isNullOrEmpty(inputConferenceSession.getName())) {
			managedConferenceSession.setName(inputConferenceSession.getName());
		}

		if (!Strings.isNullOrEmpty(inputConferenceSession.getShortDesc())) {
			managedConferenceSession.setShortDesc(inputConferenceSession
					.getShortDesc());
		}

		if (!Strings.isNullOrEmpty(inputConferenceSession.getFullDesc())) {
			managedConferenceSession.setFullDesc(inputConferenceSession
					.getFullDesc());
		}

		if (inputConferenceSession.getDuration() != null) {
			managedConferenceSession.setDuration(inputConferenceSession
					.getDuration());
		}

		if (inputConferenceSession.getStartDttm() != null) {
			managedConferenceSession.setStartDttm(inputConferenceSession
					.getStartDttm());
		}

		if (inputConferenceSession.getConference() != null
				&& inputConferenceSession.getConference().getId() != null) {
			managedConferenceSession.setConference(inputConferenceSession
					.getConference());
		}

		if (inputConferenceSession.getRoom() != null
				&& inputConferenceSession.getRoom().getId() != null) {
			managedConferenceSession.setRoom(inputConferenceSession.getRoom());
		}

		conferenceSessionRepository.save(managedConferenceSession);
	}

	public void deleteConferenceSession(Integer id) {
		conferenceSessionRepository.delete(id);
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

	public void addConference(Conference conference) {
		conferenceRepository.save(conference);
	}

	public void deleteConference(Integer id) {
		conferenceRepository.delete(id);
	}

	public void updateConference(Conference inputConference) {
		Conference managedConference = conferenceRepository
				.findOne(inputConference.getId());
		if (!Strings.isNullOrEmpty(inputConference.getName())) {
			managedConference.setName(inputConference.getName());
		}

		if (!Strings.isNullOrEmpty(inputConference.getShortDesc())) {
			managedConference.setShortDesc(inputConference.getShortDesc());
		}

		if (!Strings.isNullOrEmpty(inputConference.getFullDesc())) {
			managedConference.setFullDesc(inputConference.getFullDesc());
		}

		if (inputConference.getStartDate() != null) {
			managedConference.setStartDate(inputConference.getStartDate());
		}

		if (inputConference.getEndDate() != null) {
			managedConference.setEndDate(inputConference.getEndDate());
		}

		if (inputConference.getLocation() != null
				&& inputConference.getLocation().getId() != null) {
			managedConference.setLocation(inputConference.getLocation());
		}

		conferenceRepository.save(managedConference);
	}

	public Collection<RoomView> findAllRooms() {
		return RoomViewBuilder.build(roomRepository.findAll());
	}

	public RoomView findRoomById(Integer id) {
		return RoomViewBuilder.build(roomRepository.findOne(id));
	}

	public Collection<SponsorView> findAllSponsors() {
		return SponsorBuilder.build(sponsorRepository.findAll());
	}

	public SponsorView findSponsorById(Integer id) {
		return SponsorBuilder.build(sponsorRepository.findOne(id));
	}

	public void deleteSponsor(Integer id) {
		sponsorRepository.delete(id);
	}

	public void addSponsor(Sponsor sponsor) {
		sponsorRepository.save(sponsor);
	}

	public void updateSponsor(Sponsor inputSponsor) {
		Sponsor managedSponsor = sponsorRepository
				.findOne(inputSponsor.getId());
		if (!Strings.isNullOrEmpty(inputSponsor.getHomePageUrl())) {
			managedSponsor.setHomePageUrl(inputSponsor.getHomePageUrl());
		}
		if (!Strings.isNullOrEmpty(inputSponsor.getLogoPath())) {
			managedSponsor.setLogoPath(inputSponsor.getLogoPath());
		}
		if (!Strings.isNullOrEmpty(inputSponsor.getName())) {
			managedSponsor.setName(inputSponsor.getName());
		}
		if (inputSponsor.getSponsorLevelBean() != null
				&& inputSponsor.getSponsorLevelBean().getId() != null) {
			SponsorLevel sponsorLevel = new SponsorLevel();
			sponsorLevel.setId(inputSponsor.getSponsorLevelBean().getId());
			managedSponsor.setSponsorLevelBean(sponsorLevel);
		}
		sponsorRepository.save(managedSponsor);
	}

	public Collection<SponsorLevelView> findAllSponsorLevels() {
		return SponsorLevelBuilder.build(sponsorLevelRepository.findAll());
	}

	public void addRoom(Room room) {
		roomRepository.save(room);
	}

	public void deleteRoom(Integer id) {
		roomRepository.delete(id);
	}

	public void updateRoom(Room inputRoom) {
		Room managedRoom = roomRepository.findOne(inputRoom.getId());

		if (!Strings.isNullOrEmpty(inputRoom.getShortDesc())) {
			managedRoom.setShortDesc(inputRoom.getShortDesc());
		}
		if (!Strings.isNullOrEmpty(inputRoom.getFullDesc())) {
			managedRoom.setFullDesc(inputRoom.getFullDesc());
		}
		if (inputRoom.getConference() != null
				&& inputRoom.getConference().getId() != null) {
			Conference conference = new Conference();
			conference.setId(inputRoom.getConference().getId());
			managedRoom.setConference(conference);
		}

		roomRepository.save(managedRoom);
	}

}
