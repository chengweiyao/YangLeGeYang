package com.cwy.test;

import com.cwy.model.Layer;
import com.cwy.model.Map;
import com.cwy.util.LayerUtil;

public class TestBuildMap {
    public static void main(String[] args) {
        Map map =new Map();
        map.setFloorHeight(3);
        Layer layer1 = LayerUtil.build(3,3);
        Layer layer2 = LayerUtil.build(6,6);
        Layer layer3 = LayerUtil.build(9,9);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);


    }
}
