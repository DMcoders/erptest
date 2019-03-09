package com.example.erp01.model;

public class EmbryoInbound {

    private Integer embryoinboundID;

    private String embryostoreQcode;

    private String tailorQcode;

    public EmbryoInbound(String embryostoreQcode, String tailorQcode) {
        this.embryostoreQcode = embryostoreQcode;
        this.tailorQcode = tailorQcode;
    }

    public Integer getEmbryoinboundID() {
        return embryoinboundID;
    }

    public void setEmbryoinboundID(Integer embryoinboundID) {
        this.embryoinboundID = embryoinboundID;
    }

    public String getEmbryostoreQcode() {
        return embryostoreQcode;
    }

    public void setEmbryostoreQcode(String embryostoreQcode) {
        this.embryostoreQcode = embryostoreQcode;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
