package com.ioextendedgr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ioextendedgr.web.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
