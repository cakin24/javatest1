package com.itheima.pattern.visitor;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: cakin
 */
public class Client {
    public static void main(String[] args) {
        // 创建Home对象
        Home home = new Home();
        // 添加元素到Home对象中
        home.add(new Dog());
        home.add(new Cat());

        // 创建主人对象
        Owner owner = new Owner();
        // 让主人喂食所有的宠物
        home.action(owner);
        // 创建其他人
        Someone someone = new Someone();
        // 其他人喂东食所有宠物
        home.action(someone);
    }
}
