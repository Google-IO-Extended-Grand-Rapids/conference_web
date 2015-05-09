package com.ioextendedgr.web.controller;


import com.ioextendedgr.web.data.Presenter;
import com.ioextendedgr.web.data.Room;
import com.ioextendedgr.web.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/room")
public class AdminRoomController {

    private static final Logger logger = LoggerFactory.getLogger(AdminRoomController.class);

    public static final String ROOM_VIEW = "room";

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRoomView(ModelMap model) {
        model.addAttribute("rooms", conferenceService.findAllRooms());
        model.addAttribute("conferences", conferenceService.findAllConferences());
        return ROOM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRoom(Room room, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.getAllErrors().toString());
        }
        conferenceService.addRoom(room);
        return "redirect:" + ROOM_VIEW;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteRoom(@RequestParam Integer id) {
        conferenceService.deleteRoom(id);
        return "redirect:" + ROOM_VIEW;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateroom(Room room) {
        conferenceService.updateRoom(room);
        return "redirect:" + ROOM_VIEW;
    }

}
