package com.ioextendedgr.web.repository;

import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.data.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer>{
	
}
