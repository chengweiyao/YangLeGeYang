package com.cwy.model;

import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class EliminateBox {
    private static final List<Brand> slot = new ArrayList<>();

    void deleteByBrandName(String name){
        Iterator<Brand> iterator = slot.iterator();
        while(iterator.hasNext()){
            Brand next = iterator.next();
            if(next.getName().equals(name)){
                next.getParent().remove(next);
                iterator.remove();
            }
        }
    }

    public void addSlot(Brand brand){
        slot.add(brand);
        slot.sort(Comparator.comparing(Brand::getName));
        Map<String,List<Brand>> map =slot.stream().collect(Collectors.groupingBy(Brand::getName));
        Set<String> key = map.keySet();
        for(String s:key){
            List<Brand> brands = map.get(s);
            if(brands.size() == 3){
                deleteByBrandName(brand.getName());
                break;
            }
        }
        paint();
        over(brand);
    }

    void paint(){
        for (int i = 0; i < slot.size(); i++) {
            Brand brand = slot.get(i);
            int x  = i* brand.getWidth()+10;
            brand.setBounds(x,600,50,50);
        }
    }
    void over(Brand brand){
        if(slot.size()>=7){
            JOptionPane.showMessageDialog(brand,"游戏结束");
            System.exit(0);
        }
    }
}
