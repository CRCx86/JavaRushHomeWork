package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by zinov.av on 26.05.2016.
 */
public class Singleton {

    static Singleton singletone = null;

    static Singleton getInstance(){
        return singletone;
    }

    private Singleton(){}

}
