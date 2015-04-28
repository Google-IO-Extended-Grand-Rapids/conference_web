package com.ioextendedgr.web.builder;

import com.ioextendedgr.web.data.Company;
import com.ioextendedgr.web.data.Location;
import com.ioextendedgr.web.viewDto.CompanyView;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CompanyBuilder {

    public static List<CompanyView> build(Collection<Company> datas) {
        if (CollectionUtils.isEmpty(datas)) {
            return new ArrayList<>();
        }

        List<CompanyView> views = new ArrayList<>();
        for (Company data : datas) {
            views.add(build(data));
        }
        return views;
    }


    public static CompanyView build(Company data) {
        if (data == null)
            return null;

        CompanyView view = new CompanyView();

        view.setId(data.getId());
        view.setName(data.getName());
        view.setShortDesc(data.getShortDesc());
        view.setFullDesc(data.getFullDesc());
        view.setLogoPath(data.getLogoPath());
        return view;
    }



    }
