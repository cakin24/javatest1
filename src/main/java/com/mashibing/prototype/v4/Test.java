package com.mashibing.prototype.v4;

/**
 * @author: Yuanzt
 * @Date: 2021/3/19
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println("p1.loc == p2.loc? " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);

    }
}

class Person implements  Cloneable{
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuilder("bj"),22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }
}

class Location implements Cloneable{
    StringBuilder street;
    int roomNo;

    public Location(StringBuilder street,int roomNo){
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}