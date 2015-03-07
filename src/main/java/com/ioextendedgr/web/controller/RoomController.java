package com.ioextendedgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioextendedgr.web.service.ConferenceService;
import com.ioextendedgr.web.viewDto.RoomView;

@RestController
@RequestMapping("/api")
public class RoomController {

	@Autowired
	ConferenceService conferenceService;

	@RequestMapping("/room/{id}")
	public RoomView findRoomById(@PathVariable("id") Integer id) {
		return conferenceService.findRoomById(id);
	}

}
