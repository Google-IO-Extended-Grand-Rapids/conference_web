package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Location;
import com.ioextendedgr.web.viewDto.LocationView;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class LocationBuilder {

    public static List<LocationView> build(Collection<Location> datas) {
        if (CollectionUtils.isEmpty(datas)) {
            return new ArrayList<>();
        }

        List<LocationView> views = new ArrayList<>();
        for (Location data : datas) {
            views.add(build(data));
        }
        return views;
    }


    public static LocationView build(Location data) {
        if (data == null)
            return null;

        LocationView view = new LocationView();

        view.setId(data.getId());
        view.setName(data.getName());
        view.setShortDesc(data.getShortDesc());
        view.setFullDesc(data.getFullDesc());
        view.setCreateDttm(data.getCreateDttm());
        view.setLastUpdateDttm(data.getLastUpdateDttm());
        view.setParkingInfo(data.getParkingInfo());
        return view;
    }



    }
