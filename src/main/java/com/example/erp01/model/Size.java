package com.example.erp01.model;


public class Size {

    private Integer sizeID;

    private String sizeName;

    public Size(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}
