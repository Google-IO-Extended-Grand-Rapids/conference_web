package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Room;
import com.ioextendedgr.web.viewDto.RoomView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomViewBuilder {

    public static Collection<RoomView> build(Collection<Room> dtos) {
        List<RoomView> rooms = new ArrayList<>();
        for (Room currRoom : dtos) {
            rooms.add(build(currRoom));
        }
        return rooms;
    }

	public static RoomView build(Room data) {
		if (data == null) {
			return null;
		}

		RoomView view = new RoomView();

		view.setId(data.getId());
		view.setShortDesc(data.getShortDesc());
		view.setFullDesc(data.getFullDesc());
		view.setConferenceId(data.getConference().getId());

		return view;
	}
}
