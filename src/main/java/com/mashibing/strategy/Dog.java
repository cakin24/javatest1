package com.mashibing.strategy;

/**
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public class Dog implements Comparable<Dog> {

    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog dog) {
        if (this.food < dog.food)
            return -1;
        else if (this.food > dog.food)
            return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
