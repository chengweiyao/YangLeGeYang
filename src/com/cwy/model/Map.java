package com.cwy.model;

import com.cwy.util.MapUtil;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Integer floorHeight; //层高
    private List<Layer> list =new ArrayList<>();






    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getList() {
        return list;
    }



    public void compareAll(){
        for (int i = 1; i < list.size(); i++) {
            Layer layer = list.get(i);
            Cell[][] cells = layer.getCells();
            for (Cell[] value : cells) {
                for (Cell cell : value) {
                    if (cell.getState() == 1) {
                        Brand brand = cell.getBrand();
                        boolean result = MapUtil.compare(brand, layer.getParent());
                        brand.setGray(result);
                    }
                }
            }
        }
    }
}
