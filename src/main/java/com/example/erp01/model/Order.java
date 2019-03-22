package com.example.erp01.model;

import java.util.Date;

public class Order {

    private Integer orderID;

    private String orderName;

    private Integer customerName;

    private Date orderDate;

    private Date orderDeadline;

    private Integer orderTotalCount;

    private String orderNote;

    public Order(String orderName, Integer customerName, Date orderDate, Date orderDeadline, Integer orderTotalCount) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderDeadline = orderDeadline;
        this.orderTotalCount = orderTotalCount;
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

    public Integer getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Integer customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDeadline() {
        return orderDeadline;
    }

    public void setOrderDeadline(Date orderDeadline) {
        this.orderDeadline = orderDeadline;
    }

    public Integer getOrderTotalCount() {
        return orderTotalCount;
    }

    public void setOrderTotalCount(Integer orderTotalCount) {
        this.orderTotalCount = orderTotalCount;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }
}
