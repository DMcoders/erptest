package com.example.erp01.model;

public class EmbryoStore {

    private Integer embryostoreID;

    private String embryostoreLocation;

    private String embryostoreQcode;

    public EmbryoStore(String embryostoreLocation, String embryostoreQcode) {
        this.embryostoreLocation = embryostoreLocation;
        this.embryostoreQcode = embryostoreQcode;
    }

    public String getEmbryostoreLocation() {
        return embryostoreLocation;
    }

    public void setEmbryostoreLocation(String embryostoreLocation) {
        this.embryostoreLocation = embryostoreLocation;
    }

    public String getEmbryostoreQcode() {
        return embryostoreQcode;
    }

    public void setEmbryostoreQcode(String embryostoreQcode) {
        this.embryostoreQcode = embryostoreQcode;
    }
}
