package com.example.erp01.model;

public class Customer {


    private Integer customerID;

    private String companyName;

    private String linkmanName;

    private String linkmanPhone;

    private String companyAddress;

    private String customerNote;

    public Customer(String companyName, String linkmanName, String linkmanPhone, String companyAddress, String customerNote) {
        this.companyName = companyName;
        this.linkmanName = linkmanName;
        this.linkmanPhone = linkmanPhone;
        this.companyAddress = companyAddress;
        this.customerNote = customerNote;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }
}
