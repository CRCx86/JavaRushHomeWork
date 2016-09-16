package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Aleksandr on 01.06.2016.
 */
public class Sun implements Planet {
    private static final Sun instance = new Sun();

    private Sun(){}

    public static Sun getInstance() {
        return instance;
    }
}
