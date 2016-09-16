package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int countArgs = args.length;

        switch (countArgs) {
            case 4 :
                if (args[0].equals("-c")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",  Locale.ENGLISH);
                    if (args[2].equals("м")) {
                        Person person = Person.createMale(args[1], simpleDateFormat.parse(args[3]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    if (args[2].equals("ж")) {
                        Person person = Person.createFemale(args[1], simpleDateFormat.parse(args[3]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case 5 :
                if (args[0].equals("-u")) {
                    int id = Integer.parseInt(args[1]);
                    if (id > 0) {
                        Person person = allPeople.get(id);
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy",  Locale.ENGLISH).parse(args[4]));
                        person.setName(args[2]);
                        if (args[3].equals("м")) person.setSex(Sex.MALE);
                        if (args[3].equals("ж")) person.setSex(Sex.FEMALE);;
                        allPeople.set(id, person);
                    }
                }
                break;
            case 2 :
                if (args[0].equals("-d")) {
                    int id = Integer.parseInt(args[1]);
                    if (id > 0) {
                        Person person = allPeople.get(id);
                        person.setSex(null);
                        person.setName(null);
                        person.setBirthDay(null);
                        allPeople.set(id, person);
                    }
                }
                if (args[0].equals("-i")) {
                    int id = Integer.parseInt(args[1]);
                    if (id >= 0) {
                        try {
                            String name = allPeople.get(id).getName();
                            Sex sex = allPeople.get(id).getSex();
                            String stringSex = "";
                            if (sex == Sex.MALE) {
                                stringSex = "м";
                            }
                            if (sex == Sex.FEMALE) {
                                stringSex = "ж";
                            }
                            Date date = allPeople.get(id).getBirthDay();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(name + " " + stringSex + " " + simpleDateFormat.format(date));

                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Нет элемента с таким индексом");
                        }

                    }
                }
                break;
            default:
        }

    }
}