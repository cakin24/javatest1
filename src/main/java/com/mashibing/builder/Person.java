package com.mashibing.builder;

/**
 * @author: Yuanzt
 * @Date: 2021/3/18
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person(){}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }

    public static class PersonBuilder{
        Person p = new Person();
        public PersonBuilder basicInfo(int id,String name,int age){
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }

        public PersonBuilder weight(double weight){
            p.weight = weight;
            return this;
        }

        public PersonBuilder score(int score){
            p.score = score;
            return this;
        }

        public PersonBuilder loc(Location loc){
            p.loc = loc;
            return this;
        }

        public Person build(){
            return p;
        }
    }
}

class Location{
    String street;
    String roomNo;
    public Location(String street,String roomNo){
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}