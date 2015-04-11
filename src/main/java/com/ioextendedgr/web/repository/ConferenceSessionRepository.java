package com.ioextendedgr.web.repository;

import com.ioextendedgr.web.data.ConferenceSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Scott Williams on 3/4/2015.
 */
public interface ConferenceSessionRepository extends JpaRepository<ConferenceSession, Integer> {

    public List<ConferenceSession> findByConferenceId(Integer id);

}
