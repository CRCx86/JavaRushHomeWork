package com.javarush.test.level17.lesson10.bonus02;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static synchronized Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static synchronized Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public synchronized void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public synchronized void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
