package com.mashibing.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 * 枚举类没有构造方法，所以不能被反序列化
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public enum Mgr08 {
    INSTANCE
}
