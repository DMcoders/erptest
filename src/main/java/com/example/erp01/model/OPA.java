package com.example.erp01.model;

import java.util.Date;

public class OPA {

    private Integer opaID;

    private String orderName;

    private String customerName;

    private String destination;

    private Integer bedNumber;

    private Integer opaCount;

    private Date opaDate;

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public OPA(Integer opaID, String orderName, String customerName, String destination, Integer bedNumber, Integer opaCount, Date opaDate) {
        this.opaID = opaID;
        this.orderName = orderName;
        this.customerName = customerName;
        this.destination = destination;
        this.bedNumber = bedNumber;
        this.opaCount = opaCount;
        this.opaDate = opaDate;
    }

    public OPA() {
    }

    public OPA(String orderName, String customerName, String destination, Integer bedNumber, Integer opaCount, Date opaDate) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.destination = destination;
        this.bedNumber = bedNumber;
        this.opaCount = opaCount;
        this.opaDate = opaDate;
    }

    public Integer getOpaID() {
        return opaID;
    }

    public void setOpaID(Integer opaID) {
        this.opaID = opaID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getOpaCount() {
        return opaCount;
    }

    public void setOpaCount(Integer opaCount) {
        this.opaCount = opaCount;
    }

    public Date getOpaDate() {
        return opaDate;
    }

    public void setOpaDate(Date opaDate) {
        this.opaDate = opaDate;
    }
}
