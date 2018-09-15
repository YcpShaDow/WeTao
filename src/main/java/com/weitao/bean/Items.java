package com.weitao.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Items {
/*    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }*/

    private Integer iId;

    private String iName;

    private String iPhotos;

    private Integer iExsit;

    private Integer iSale;

    private BigDecimal iPrice;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date iDate;

    private Byte iStatus;

    private Integer storeId;

    private Integer catagoryId;


    private String iIntroduction;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public String getiPhotos() {
        return iPhotos;
    }

    public void setiPhotos(String iPhotos) {
        this.iPhotos = iPhotos == null ? null : iPhotos.trim();
    }

    public Integer getiExsit() {
        return iExsit;
    }

    public void setiExsit(Integer iExsit) {
        this.iExsit = iExsit;
    }

    public Integer getiSale() {
        return iSale;
    }

    public void setiSale(Integer iSale) {
        this.iSale = iSale;
    }

    public BigDecimal getiPrice() {
        return iPrice;
    }

    public void setiPrice(BigDecimal iPrice) {
        this.iPrice = iPrice;
    }

    public Date getiDate() {
        return iDate;
    }

    public void setiDate(Date iDate) {
        this.iDate = iDate;
    }

    public Byte getiStatus() {
        return iStatus;
    }

    public void setiStatus(Byte iStatus) {
        this.iStatus = iStatus;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getiIntroduction() {
        return iIntroduction;
    }

    public void setiIntroduction(String iIntroduction) {
        this.iIntroduction = iIntroduction == null ? null : iIntroduction.trim();
    }

    @Override
    public String toString() {
        return "Items{" +
                ", iId=" + iId +
                ", iName='" + iName + '\'' +
                ", iPhotos='" + iPhotos + '\'' +
                ", iExsit=" + iExsit +
                ", iSale=" + iSale +
                ", iPrice=" + iPrice +
                ", iDate=" + iDate +
                ", iStatus=" + iStatus +
                ", storeId=" + storeId +
                ", catagoryId=" + catagoryId +
                ", iIntroduction='" + iIntroduction + '\'' +
                '}';
    }
}