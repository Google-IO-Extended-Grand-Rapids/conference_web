package com.ioextendedgr.web.viewDto;


public class SponsorView {

    private Integer id;
    private String homePageUrl;
    private String logoPath;
    private String name;
    private String sponsorLevelDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorLevelDesc() {
        return sponsorLevelDesc;
    }

    public void setSponsorLevelDesc(String sponsorLevelDesc) {
        this.sponsorLevelDesc = sponsorLevelDesc;
    }
}
