package com.cwy.util;

import com.cwy.model.Brand;
import com.cwy.model.Cell;
import com.cwy.model.Layer;

public class LayerUtil {
    public static Layer build(Integer rowNum,Integer colNum){
        Layer layer = null;
        try {
            layer = new Layer(rowNum,colNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert layer != null;
        Brand[] brands = BrandUtil.buildBrands(layer.getCapacity());
        Cell[][] cells = layer.getCells();
        int flag=0;
        for(int row = 0;row< cells.length;row++){
            for(int col = 0;col<cells[row].length;col++){
                Brand brands1 = brands[flag++];
                Cell cell = new Cell();
                cell.setState(1);
                cell.setBrand(brands1);

                brands1.setCell(cell);
                cells[row][col]=cell;
            }
        }
        return layer;
    }



    //打乱数组






}
