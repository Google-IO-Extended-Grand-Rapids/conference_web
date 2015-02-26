package com.ioextendedgr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ioextendedgr.web.data.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long>{
	
}
