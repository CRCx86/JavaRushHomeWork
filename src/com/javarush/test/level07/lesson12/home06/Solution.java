package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human("ded1", true, 90);
        Human ded2 = new Human("ded2", true, 89);
        Human babka1 = new Human("babka1", false, 87);
        Human babka2 = new Human("babka2", false, 86);
        Human Pavel = new Human("Павел", true, 50, ded1, babka1);
        Human Catty = new Human("Катя", false, 43, ded2, babka2);
        Human Any = new Human("Аня", false, 21, Pavel, Catty);
        Human Catrin = new Human("Катя", false, 21, Pavel, Catty);
        Human Igor = new Human("Иогрь", false, 21, Pavel, Catty);

        System.out.println(Any.toString());
        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(babka1.toString());
        System.out.println(babka2.toString());
        System.out.println(Pavel.toString());
        System.out.println(Catty.toString());
        System.out.println(Any.toString());
        System.out.println(Catrin.toString());
        System.out.println(Igor.toString());

    }

    public static class Human
    {
        //напишите тут ваш код
        Human father;
        Human mother;
        String name;
        int age;
        boolean sex;

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
