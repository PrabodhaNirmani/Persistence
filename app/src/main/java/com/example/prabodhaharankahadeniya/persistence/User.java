package com.example.prabodhaharankahadeniya.persistence;

/**
 * Created by prabodhaharankahadeniya on 7/19/17.
 */

public class User {

    private String id;
    private String name;
    private String city;
    private String age;

    public User(String name, String age, String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
    public User(String name){
        this.name=name;
    }
    public User(){

    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
}
