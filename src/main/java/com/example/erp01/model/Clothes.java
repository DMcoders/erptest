package com.example.erp01.model;

public class Clothes {

    private Integer clothesID;

    private String styleNumber;

    private String styleName;

    public Clothes(String styleNumber, String styleName) {
        this.styleNumber = styleNumber;
        this.styleName = styleName;
    }

    public Integer getClothesID() {
        return clothesID;
    }

    public void setClothesID(Integer clothesID) {
        this.clothesID = clothesID;
    }

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
