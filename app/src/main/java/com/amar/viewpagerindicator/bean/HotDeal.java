package com.amar.viewpagerindicator.bean;

/**
 * Created by "Amarnath Baitha" on 24/7/17.
 */


public class HotDeal {

    private String dealPrice;
    private String dealName;
    private String dealDescription;
    private Integer imageList;

    public HotDeal(String s, int i, String s1, String s2) {
        this.dealPrice = s;
        this.dealName = s1;
        this.dealDescription = s2;
        this.imageList = i;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public String getDealName() {
        return dealName;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public Integer getImageList() {
        return imageList;
    }
}
