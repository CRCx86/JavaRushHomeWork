package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human kid1 = new Human("kid1", true, 13, null);
        Human kid2 = new Human("kid2", true, 14, null);
        Human kid3 = new Human("kid3", true, 12, null);

        Human father = new Human("father", true, 60, kid1);

        Human mother = new Human("mother", false, 55, kid2);

        Human ded1 = new Human("ded1", true, 60, father);
        Human ded2 = new Human("ded2", true, 65, mother);

        Human babka1 = new Human("babka1", false, 55, mother);
        Human babka2 = new Human("babka2", false, 50, father);
        ArrayList<Human> family = new ArrayList<Human>();
        family.add(kid1);
        family.add(kid2);
        family.add(kid3);
        family.add(father);
        family.add(mother);
        family.add(ded1);
        family.add(ded2);
        family.add(babka1);
        family.add(babka2);
        for (Human humy : family) {
            System.out.println(humy.toString());
        }

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex, int age, Human human) {
            this.name = name;
            this.sex = sex;
            this.age = age;

            if (human != null)
                children.add(human);
            else
                this.children = new ArrayList<Human>();
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }
}

