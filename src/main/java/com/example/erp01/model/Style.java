package com.example.erp01.model;

public class Style {

    private Integer styleID;

    private String styleName;

    public Style(String styleName) {
        this.styleName = styleName;
    }

    public Integer getStyleID() {
        return styleID;
    }

    public void setStyleID(Integer styleID) {
        this.styleID = styleID;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
