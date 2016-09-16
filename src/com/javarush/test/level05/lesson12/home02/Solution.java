package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("A", 1, "B");
        Man man2 = new Man("C", 1, "D");

        Woman wooman1 = new Woman("E", 1, "F");
        Woman wooman2 = new Woman("G", 1, "H");

        //выведи их на экран тут
        System.out.println(man1.getName() + " " + man1.getAge() + " " + man1.getAddress());
        System.out.println(man2.getName() + " " + man2.getAge() + " " + man2.getAddress());
        System.out.println(wooman1.getName() + " " + wooman1.getAge() + " " + wooman1.getAddress());
        System.out.println(wooman2.getName() + " " + wooman2.getAge() + " " + wooman2.getAddress());

    }

    public static class Man{

        private
            String name;
            int age;
            String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age =  age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public int getAge() {
            return age;
        }
    }

    public static class Woman{

        private
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age =  age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public int getAge() {
            return age;
        }
    }

}
