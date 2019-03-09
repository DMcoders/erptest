package com.example.erp01.model;


public class Size {

    private Integer sizeID;

    private Integer sizeName;

    public Size(Integer sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public Integer getSizeName() {
        return sizeName;
    }

    public void setSizeName(Integer sizeName) {
        this.sizeName = sizeName;
    }
}
