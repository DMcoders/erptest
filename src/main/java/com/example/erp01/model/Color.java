package com.example.erp01.model;

public class Color {



    private Integer colorID;

    private String colorName;

    public Color(String colorName) {
        this.colorName = colorName;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
