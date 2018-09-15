package com.weitao.bean;

public class Store {
    private Integer stId;

    private String stName;

    private Byte stStatus;

    private Integer sellerId;

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }

    public Byte getStStatus() {
        return stStatus;
    }

    public void setStStatus(Byte stStatus) {
        this.stStatus = stStatus;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Store{" +
                "stId=" + stId +
                ", stName='" + stName + '\'' +
                ", stStatus=" + stStatus +
                ", sellerId=" + sellerId +
                '}';
    }
}