package com.example.erp01.model;

public class EmbProductionPlan {

    private Integer embProductionPlanID;

    private String orderName;

    private String colorName;

    private String sizeName;

    private String workshopName;

    private String groupName;

    private Integer planCount;

    private Integer actualCount;

    public EmbProductionPlan(String orderName, String colorName, String sizeName, String workshopName, String groupName, Integer planCount, Integer actualCount) {
        this.orderName = orderName;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.workshopName = workshopName;
        this.groupName = groupName;
        this.planCount = planCount;
        this.actualCount = actualCount;
    }

    public Integer getEmbProductionPlanID() {
        return embProductionPlanID;
    }

    public void setEmbProductionPlanID(Integer embProductionPlanID) {
        this.embProductionPlanID = embProductionPlanID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    public Integer getActualCount() {
        return actualCount;
    }

    public void setActualCount(Integer actualCount) {
        this.actualCount = actualCount;
    }
}
