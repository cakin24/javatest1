package com.mashibing.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Yuanzt
 * @Date: 2021/3/17
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank) context.getBean("tank");
        tank.move();
    }
}
