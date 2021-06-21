//package com.mashibing.spring.v2;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//
///**
// * @author: Yuanzt
// * @Date: 2021/3/17
// */
//@Aspect
//public class TimeProxy {
//
//    @Before("execution(void com.mashibing.spring.v2.Tank.move())")
//    public void before(){
//        System.out.println("method annotation start..." + System.currentTimeMillis());
//    }
//
//    @After("execution(void com.mashibing.spring.v2.Tank.move())")
//    public void after(){
//        System.out.println("method annotation end..." + System.currentTimeMillis());
//    }
//}
