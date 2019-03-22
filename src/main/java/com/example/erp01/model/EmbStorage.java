package com.example.erp01.model;

public class EmbStorage {

    private Integer embStorageID;

    private String embStoreQcode;

    private String tailorCode;

    public Integer getEmbStorageID() {
        return embStorageID;
    }

    public void setEmbStorageID(Integer embStorageID) {
        this.embStorageID = embStorageID;
    }

    public String getEmbStoreQcode() {
        return embStoreQcode;
    }

    public void setEmbStoreQcode(String embStoreQcode) {
        this.embStoreQcode = embStoreQcode;
    }

    public String getTailorCode() {
        return tailorCode;
    }

    public void setTailorCode(String tailorCode) {
        this.tailorCode = tailorCode;
    }

    public EmbStorage() {
    }

    public EmbStorage(String embStoreQcode, String tailorCode) {
        this.embStoreQcode = embStoreQcode;
        this.tailorCode = tailorCode;
    }

    public EmbStorage(Integer embStorageID, String embStoreQcode, String tailorCode) {
        this.embStorageID = embStorageID;
        this.embStoreQcode = embStoreQcode;
        this.tailorCode = tailorCode;
    }
}
