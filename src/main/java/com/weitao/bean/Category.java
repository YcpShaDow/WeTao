package com.weitao.bean;

public class Category {
    private Integer caId;

    private String caName;

    private String caFather;

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }

    public String getCaFather() {
        return caFather;
    }

    public void setCaFather(String caFather) {
        this.caFather = caFather == null ? null : caFather.trim();
    }

    @Override
    public String toString() {
        return "Category{" +
                "caId=" + caId +
                ", caName='" + caName + '\'' +
                ", caFather='" + caFather + '\'' +
                '}';
    }
}