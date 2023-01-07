package com.cwy.model;

public class Cell {
    private Integer state = 0;//0 无牌 1 有牌
    private Brand brand;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
