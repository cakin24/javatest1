package com.mashibing.spring.v1;

/**
 * @author: Yuanzt
 * @Date: 2021/3/17
 */
public class TimeProxy {

    public void before(){
        System.out.println("method start..." + System.currentTimeMillis());
    }

    public void after(){
        System.out.println("method end..." + System.currentTimeMillis());
    }

}
