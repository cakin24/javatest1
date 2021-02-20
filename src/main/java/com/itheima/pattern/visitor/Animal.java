package com.itheima.pattern.visitor;

/**
 * @version v1.0
 * @ClassName: Animal
 * @Description: 抽象元素角色类
 * @Author: cakin
 */
public interface Animal {
    // 接受访问者访问的功能，其意义是指，每一个元素都要可以被访问者访问。
    void accept(Person person);
}
