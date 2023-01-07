package com.cwy.util;

import com.cwy.model.Brand;

import java.util.Random;

public class BrandUtil {
    public static Random random = new Random();

    public static String[] brandNames={
            "刷子","剪刀","叉子",
            "手套","水桶","火",
            "玉米","球","瓶子",
            "白菜","稻草","肉腿",
            "胡萝卜","苹果","苹果",
            "铃铛","青草"
    };
    public static String getBrandName(){
        int randomIndex = random.nextInt(brandNames.length);
        return brandNames[randomIndex];
    }

    public static  Brand[] buildBrands(Integer capacity){

        Brand[] brands = new Brand[capacity];//等于图层的容量

        for(int i=0;i<brands.length;i+=3){
            String randomBrandName = getBrandName();
            Brand brand1 = new Brand(randomBrandName);
            Brand brand2 = new Brand(randomBrandName);
            Brand brand3 = new Brand(randomBrandName);
            brands[i] = brand1;
            brands[i+1] = brand2;
            brands[i+2] = brand3;
        }
        //交换
        for(int i=0;i<brands.length;i++){
            Brand brandA = brands[i];
            int randomIndex = random.nextInt(brands.length);
            Brand brandB = brands[randomIndex];
            brands[i]=brandB;
            brands[randomIndex]= brandA;
        }
        return  brands;
    }
}
