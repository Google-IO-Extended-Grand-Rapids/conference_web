package com.ioextendedgr.web.repository;

import com.ioextendedgr.web.data.Sponsor;
import com.ioextendedgr.web.data.SponsorLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorLevelRepository extends JpaRepository<SponsorLevel, Integer>{
	
}
