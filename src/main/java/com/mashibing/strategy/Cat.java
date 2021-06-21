package com.mashibing.strategy;

/**
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public class Cat implements Comparable<Cat>{

    int weight,height;


    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        if (this.weight < cat.weight)
            return -1;
        else if (this.weight > cat.weight)
            return 1;
        else return 0;
    }
}
