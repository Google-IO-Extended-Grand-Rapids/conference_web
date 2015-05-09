package com.ioextendedgr.web.repository;

import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.data.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
}
