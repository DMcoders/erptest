package com.example.erp01.model;

public class Inbound {

    private Integer inboundID;

    private String storehouseQcode;

    private String tailorQcode;

    public Inbound(String storehouseQcode, String tailorQcode) {
        this.storehouseQcode = storehouseQcode;
        this.tailorQcode = tailorQcode;
    }

    public Integer getInboundID() {
        return inboundID;
    }

    public void setInboundID(Integer inboundID) {
        this.inboundID = inboundID;
    }

    public String getStorehouseQcode() {
        return storehouseQcode;
    }

    public void setStorehouseQcode(String storehouseQcode) {
        this.storehouseQcode = storehouseQcode;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
