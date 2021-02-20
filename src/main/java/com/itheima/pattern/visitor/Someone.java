package com.itheima.pattern.visitor;

/**
 * @version v1.0
 * @ClassName: Owner
 * @Description: 具体访问者角色类(其他人)
 * 给出对每一个元素类访问时所产生的具体行为
 * @Author: cakin
 */
public class Someone implements Person {

    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
