package com.cwy.util;

import com.cwy.model.Brand;
import com.cwy.model.Cell;
import com.cwy.model.Layer;
import com.cwy.model.Map;

import java.awt.*;

public class MapUtil {
    public static Map build(Integer floorHeight){
        Map map = new Map();
        map.setFloorHeight(floorHeight);

        Layer layer1 = LayerUtil.build(3,3);
        Layer layer2 = LayerUtil.build(3,3);
        Layer layer3 = LayerUtil.build(3,3);

        layer3.setParent(layer2);
        layer2.setParent(layer1);
        layer1.setParent(null);


        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);

        return map;
    }

    public static boolean compare (Brand brand,Layer layer){
        Cell[][] cells = layer.getCells();
        for (Cell[] value : cells) {
            for (Cell cell : value) {
                if (cell.getState() == 1) {
                    Rectangle rect = brand.getBounds();
                    boolean result = rect.intersects(cell.getBrand().getBounds());
                    if (result) {
                        return result;
                    }
                }
            }
        }
        if(layer.getParent()!=null){
            return compare(brand,layer.getParent());
        }else{

            return false;
        }
    }
}
