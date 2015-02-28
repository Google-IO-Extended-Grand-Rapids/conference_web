package com.ioextendedgr.web;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ioextendedgr.web.data.Conference;
import com.ioextendedgr.web.data.Location;
import com.ioextendedgr.web.repository.ConferenceRepository;

@ComponentScan(basePackages = {"com.ioextendedgr.web"})
@EnableAutoConfiguration
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    ConferenceRepository cr;
    
    @Override
    public void run(String... strings) {
        Location location = new Location();
        location.setCreateDttm(new Timestamp(new Date().getTime()));
        location.setFullDesc("Anywhere but Postgres Square");
        //location.setId(Long.valueOf(1));
        location.setLastUpdateDttm(new Timestamp(new Date().getTime()));
        location.setName("MySQL Square");
        location.setParkingInfo("Parking on the street");
        location.setShortDesc("MySQL");
        
        Conference c = new Conference();
        c.setCreateDttm(new Timestamp(new Date().getTime()));
        c.setEndDate(new Timestamp(new Date().getTime()));
        c.setFullDesc("Jonas' SQL Blowout");
        //c.setId(Integer.valueOf(1));
        c.setLastUpdateDttm(new Timestamp(new Date().getTime()));
         c.setLocation(null);
         c.setName("Blue 35");
         c.setShortDesc("Why not to use postgres");
         c.setStartDate(new Timestamp(new Date().getTime()));
         
         cr.save(c);
    }

}
