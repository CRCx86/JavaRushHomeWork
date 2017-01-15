package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 14.01.2017.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {

        game = new Hippodrome();

        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

        game.printWinner();

    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {

        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {

        for (Horse horse : getHorses()) {
            horse.move();
        }

    }

    public void print() {

        for (Horse horse : getHorses()) {
            horse.print();
        }

        System.out.println();
        System.out.println();

    }

    public Horse getWinner() {

        double distance = 0;
        Horse winner = null;

        for (Horse horse : getHorses()) {
            if (horse.getDistance() >= distance) {
                distance = horse.getDistance();
                winner = horse;
            }
        }

        return winner;
    }

    public void printWinner() {

        System.out.println("Winner is " + getWinner().name + "!");

    }

}
