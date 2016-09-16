package com.javarush.test.level15.lesson12.home05;

import java.util.Objects;

/**
 * Created by Aleksandr on 01.06.2016.
 */
public class SubSolution extends Solution {
    SubSolution() {
        super();
    }

    SubSolution(Objects objects) {
        super(objects);
    }

    SubSolution(Objects objects, Objects objects1) {
        super(objects, objects1);
    }

    protected SubSolution(Character number) {
        super(number);
    }

    protected SubSolution(Short objects) {
        super(objects);
    }

    protected SubSolution(Character objects, Short objects1) {
        super(objects, objects1);
    }

    public SubSolution(Integer number) {
        super(number);
    }

    public SubSolution(Float objects) {
        super(objects);
    }

    public SubSolution(Integer objects, Float objects1) {
        super(objects, objects1);
    }

    private SubSolution(int n){}

    private SubSolution(int n, char c){}

    private SubSolution(char c){}
}
