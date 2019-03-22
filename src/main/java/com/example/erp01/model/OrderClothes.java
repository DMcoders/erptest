package com.example.erp01.model;

import java.util.Date;

public class OrderClothes {

    private Integer orderClothesID;

    private String customerName;

    private String purchaseMethod;

    private String styleNumber;

    private String styleDescription;

    private String clothesVersionNumber;

    private String colorNumber;

    private String colorName;

    private String sizeName;

    private Integer count;

    private Date orderDate;

    private Date deadlineDate;

    public OrderClothes(String customerName, String purchaseMethod, String styleNumber, String styleDescription, String clothesVersionNumber, String colorNumber, String colorName, String sizeName, Integer count, Date orderDate, Date deadlineDate) {
        this.customerName = customerName;
        this.purchaseMethod = purchaseMethod;
        this.styleNumber = styleNumber;
        this.styleDescription = styleDescription;
        this.clothesVersionNumber = clothesVersionNumber;
        this.colorNumber = colorNumber;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.count = count;
        this.orderDate = orderDate;
        this.deadlineDate = deadlineDate;
    }

    public Integer getOrderClothesID() {
        return orderClothesID;
    }

    public void setOrderClothesID(Integer orderClothesID) {
        this.orderClothesID = orderClothesID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public String getClothesVersionNumber() {
        return clothesVersionNumber;
    }

    public void setClothesVersionNumber(String clothesVersionNumber) {
        this.clothesVersionNumber = clothesVersionNumber;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
