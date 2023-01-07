package com.cwy.test;

import com.cwy.model.Brand;
import com.cwy.model.Cell;
import com.cwy.model.Layer;
import com.cwy.model.Map;
import com.cwy.util.MapUtil;


import javax.swing.*;
import java.util.List;

public class TestRenderLayer extends JFrame {
    public static  Map map = MapUtil.build(3);

    public TestRenderLayer(){

        init();
        List<Layer> list = map.getList();
        for (Layer layer : list) {
            renderLayer(layer);
        }
        map.compareAll();
        autoRefresh();
    }

    private void init(){
        this.setTitle("尚学堂Java版-羊了个羊游戏案例");
        this.setSize(450,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//自己的程序也会关
        this.setLocationRelativeTo(null);//居中
        this.setLayout(null);
        this.setVisible(true);
    }
    private void renderLayer(Layer layer){
        //2.渲染图层
        //准备到合适的位置
        Cell[][] cells = layer.getCells();
        for(int row = 0;row<cells.length;row++){
            for(int col =0;col< cells[row].length;col++){
                Brand brands1 = cells[row][col].getBrand();
                int x = col*50+ layer.getOffsetx();
                int y = row*50+ layer.getOffsety();
                brands1.setBounds(x,y,50,50);
                this.getContentPane().add(brands1);
            }
        }
    }

    private void autoRefresh(){
        JFrame start = this;
        new Thread(() -> {
            while (true){
                start.repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        new TestRenderLayer();
    }

}
