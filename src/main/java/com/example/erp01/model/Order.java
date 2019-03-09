package com.example.erp01.model;

import java.util.Date;

public class Order {

    private Integer orderID;

    private String orderName;

    private Integer customerID;

    private Integer clothesID;

    private Integer clothesCount;

    private Date orderDeadline;

    private String orderNote;

    public Order(String orderName, Integer customerID, Integer clothesID, Integer clothesCount, Date orderDeadline, String orderNote) {
        this.orderName = orderName;
        this.customerID = customerID;
        this.clothesID = clothesID;
        this.clothesCount = clothesCount;
        this.orderDeadline = orderDeadline;
        this.orderNote = orderNote;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getClothesID() {
        return clothesID;
    }

    public void setClothesID(Integer clothesID) {
        this.clothesID = clothesID;
    }

    public Integer getClothesCount() {
        return clothesCount;
    }

    public void setClothesCount(Integer clothesCount) {
        this.clothesCount = clothesCount;
    }

    public Date getOrderDeadline() {
        return orderDeadline;
    }

    public void setOrderDeadline(Date orderDeadline) {
        this.orderDeadline = orderDeadline;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }
}
