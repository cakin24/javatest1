package com.mashibing.spring.v1;

import java.util.Random;

/**
 * @author: Yuanzt
 * @Date: 2021/3/17
 */
public class Tank {

    public void move(){
        System.out.println("Tank moving...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
