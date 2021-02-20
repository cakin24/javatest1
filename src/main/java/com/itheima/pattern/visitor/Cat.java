package com.itheima.pattern.visitor;

/**
 * @version v1.0
 * @ClassName: Cat
 * @Description: 具体元素角色类（宠物猫）
 * 提供接受访问方法的具体实现，而这个具体的实现，通常情况下是使用访问者提供的访问该元素类的方法。
 * @Author: cakin
 */
public class Cat implements Animal {

    public void accept(Person person) {
        person.feed(this); // 访问者给宠物猫喂食
        System.out.println("好好吃，喵喵喵。。。");
    }
}
