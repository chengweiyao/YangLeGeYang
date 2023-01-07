package com.cwy.view;

import com.cwy.model.Brand;

import javax.swing.*;

public class Start extends JFrame {

    private final Brand brand =  new Brand("刷子");

    public Start(){
        this.setTitle("尚学堂Java版-羊了个羊游戏案例");
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//自己的程序也会关
        this.setLocationRelativeTo(null);//居中


        this.getContentPane().add(brand);
        //自动刷新线程
        autoRefresh();
        this.setVisible(true);
    }
    private void autoRefresh(){
        Start start = this;
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

    //主线程
    public static void main (String[] args){
        new Start();
    }
}
