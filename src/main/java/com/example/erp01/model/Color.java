package com.example.erp01.model;

public class Color {



    private Integer colorID;

    private String colorNumber;

    private String colorName;

    public Color(String colorNumber, String colorName) {
        this.colorNumber = colorNumber;
        this.colorName = colorName;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
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
}
