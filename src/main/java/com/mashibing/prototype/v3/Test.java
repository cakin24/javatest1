package com.mashibing.prototype.v3;

/**
 * String类型不需要深克隆
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
        System.out.println(p1.loc);
        System.out.println(p2.loc);
    }
}

class Person implements Cloneable{

    int age = 8;
    int score = 100;

    Location loc = new Location("bj",22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) p.loc.clone();
        return p;
    }
}

class Location implements Cloneable{
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}