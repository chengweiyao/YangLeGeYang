package com.cwy.model;

import java.util.Random;

public class Layer {
    private final Integer offsetx;//偏移量
    private final Integer offsety;//偏移量
    private final Integer capacity;//当前图层最多容纳的牌数量
    private Layer parent;//上一层对象


    private final Cell[][] cells;

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public Layer(Integer rowNum, Integer colNum) throws Exception {
        //有多少行
        //有多少列
        this.capacity = rowNum * colNum;
        if (this.capacity % 3 != 0) {
            throw new Exception("容量不是3的倍数！！！");
        }
        this.cells = new Cell[colNum][colNum];
        //图层目前有多少牌
        Integer size = 0;//图层目前有多少牌
        this.offsetx = new Random().nextInt(100);
        this.offsety = new Random().nextInt(100);
    }

    public Integer getOffsety() {
        return offsety;
    }


    public Integer getOffsetx() {
        return offsetx;
    }


    public Cell[][] getCells() {
        return cells;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
