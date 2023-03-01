package com.kh.gym.vo;

public class ProductVO {
    private String productName;
    private int Duration;
    private int ptCount;
    private int price;
    private String desc;

    public ProductVO(String productName, int duration, int ptCount, int price, String desc) {
        this.productName = productName;
        Duration = duration;
        this.ptCount = ptCount;
        this.price = price;
        this.desc = desc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public int getPtCount() {
        return ptCount;
    }

    public void setPtCount(int ptCount) {
        this.ptCount = ptCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
