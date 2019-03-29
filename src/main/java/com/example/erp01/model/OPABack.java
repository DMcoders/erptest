package com.example.erp01.model;

public class OPABack {

    private Integer opaBackID;

    private String tailorQcode;

    public OPABack() {
    }

    public OPABack(Integer opaBackID, String tailorQcode) {
        this.opaBackID = opaBackID;
        this.tailorQcode = tailorQcode;
    }

    public OPABack(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }

    public Integer getOpaBackID() {
        return opaBackID;
    }

    public void setOpaBackID(Integer opaBackID) {
        this.opaBackID = opaBackID;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
