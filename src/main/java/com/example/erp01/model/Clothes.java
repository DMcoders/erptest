package com.example.erp01.model;

public class Clothes {

    private Integer clothesID;

    private String clothesName;

    private Integer styleID;

    private Integer colorID;

    private Integer sizeID;

    private String clothesNote;

    public Clothes(String clothesName, Integer styleID, Integer colorID, Integer sizeID, String clothesNote) {
        this.clothesName = clothesName;
        this.styleID = styleID;
        this.colorID = colorID;
        this.sizeID = sizeID;
        this.clothesNote = clothesNote;
    }

    public Integer getClothesID() {
        return clothesID;
    }

    public void setClothesID(Integer clothesID) {
        this.clothesID = clothesID;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public Integer getStyleID() {
        return styleID;
    }

    public void setStyleID(Integer styleID) {
        this.styleID = styleID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public String getClothesNote() {
        return clothesNote;
    }

    public void setClothesNote(String clothesNote) {
        this.clothesNote = clothesNote;
    }
}
