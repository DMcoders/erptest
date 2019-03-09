package com.example.erp01.model;

public class OPA {

    private Integer opaID;

    private String tailorQcode;

    public OPA(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }

    public Integer getOpaID() {
        return opaID;
    }

    public void setOpaID(Integer opaID) {
        this.opaID = opaID;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
