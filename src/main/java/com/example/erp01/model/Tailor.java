package com.example.erp01.model;

public class Tailor {

    private Integer tailorID;

    private Integer orderID;

    private Integer bedNumber;

    private Integer layerNumber;

    private Integer styleID;

    private Integer sizeID;

    private Integer colorID;

    private Integer packageNumber;

    private String partName;

    private String tailorQcode;

    public Tailor(Integer orderID, Integer bedNumber, Integer layerNumber, Integer styleID, Integer sizeID, Integer colorID, Integer packageNumber, String partName, String tailorQcode) {
        this.orderID = orderID;
        this.bedNumber = bedNumber;
        this.layerNumber = layerNumber;
        this.styleID = styleID;
        this.sizeID = sizeID;
        this.colorID = colorID;
        this.packageNumber = packageNumber;
        this.partName = partName;
        this.tailorQcode = tailorQcode;
    }

    public Integer getTailorID() {
        return tailorID;
    }

    public void setTailorID(Integer tailorID) {
        this.tailorID = tailorID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getLayerNumber() {
        return layerNumber;
    }

    public void setLayerNumber(Integer layerNumber) {
        this.layerNumber = layerNumber;
    }

    public Integer getStyleID() {
        return styleID;
    }

    public void setStyleID(Integer styleID) {
        this.styleID = styleID;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
