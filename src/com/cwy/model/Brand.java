package com.cwy.model;


import com.cwy.test.TestRenderLayer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Brand extends Component{
    private String name;//牌的名称
    private Boolean isGray;//是否置灰
    private Image image ;//正常的图片
    private Image grayImage ;//灰色的图片

    private final Integer x;
    private final Integer y;
    private Cell cell;

    EliminateBox eliminateBox = new EliminateBox();
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Brand(String name){
        this.name = name;
        this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
        this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_gray.png");
        this.isGray = false;
        Integer width = 50;
        Integer height = 50;
        this.x = 0;
        this.y = 0;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Brand");
                Brand brand = (Brand) e.getSource();//获取组件
                if(!brand.getGray()){
                    eliminateBox.addSlot(brand);
                    cell.setState(0);
                    cell.setBrand(null);
                    TestRenderLayer.map.compareAll();
                }
            }
        });
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Boolean getGray() {
        return isGray;
    }

    public void setGray(Boolean gray) {
        isGray = gray;
    }









    @Override
    public void paint(Graphics g) {
        if(this.isGray){
            g.drawImage(this.grayImage,this.x,this.y,null);//灰色
        }else{
            g.drawImage(this.image,this.x,this.y,null);
        }
    }
}
