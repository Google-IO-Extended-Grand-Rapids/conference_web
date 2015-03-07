package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Room;
import com.ioextendedgr.web.viewDto.RoomView;

public class RoomViewBuilder {
	public static RoomView build(Room data) {
		if (data == null) {
			return null;
		}

		RoomView view = new RoomView();

		view.setId(data.getId());
		view.setShortDesc(data.getShortDesc());
		view.setFullDesc(data.getFullDesc());

		return view;
	}
}
