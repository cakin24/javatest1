package com.mashibing.prototype.v1;

/**
 * 原型模式
 * 实现原型模式，需要实现标记型接口cloneable接口
 * 一般会重写clone()方法
 *      如果只是重写clone()方法，而没有实现接口，调用时会报异常
 *  一般用于一个对象的属性已经确定，需要产生很多相同对象的时候
 *  需要区分深克隆和浅克隆
 * 浅克隆，loc指向的是同一个对象
 * @author: Yuanzt
 * @Date: 2021/3/19
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age+" "+p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }

}

class Person implements Cloneable{
    int age = 8;
    int score = 100;

    Location loc = new Location("bj",22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Location{
    String street;
    int roomNo;

    public Location(String street,int roomNo){
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
