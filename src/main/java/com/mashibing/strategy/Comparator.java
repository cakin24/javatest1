package com.mashibing.strategy;

/**
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1,T t2);
}
