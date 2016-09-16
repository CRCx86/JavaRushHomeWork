package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        int countArgs = args.length;

        if (args[0].equals("-c")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",  Locale.ENGLISH);
            int index = 1;
            while (index < countArgs) {

                String stringOfName = args[index];
                index++;
                String stringOfSex = args[index];
                index++;
                String stringOfBd = args[index];
                index++;

                if (stringOfSex.equals("м")) {
                    Person person = Person.createMale(stringOfName, simpleDateFormat.parse(stringOfBd));
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
                if (stringOfSex.equals("ж")) {
                    Person person = Person.createFemale(stringOfName, simpleDateFormat.parse(stringOfBd));
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
            }
        }

        if (args[0].equals("-u")) {
            int index = 1;
            while (index < countArgs) {
                String stringOfIndex = args[index];
                index++;
                String stringOfName = args[index];
                index++;
                String stringOfSex = args[index];
                index++;
                String stringOfBd = args[index];
                index++;

                int id = Integer.parseInt(stringOfIndex);
                if (id > 0) {
                    Person person = allPeople.get(id);
                    person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(stringOfBd));
                    person.setName(stringOfName);
                    if (stringOfSex.equals("м")) person.setSex(Sex.MALE);
                    if (stringOfSex.equals("ж")) person.setSex(Sex.FEMALE);
                    ;
                    allPeople.set(id, person);
                }
            }
        }
        if (args[0].equals("-d")) {
            int index = 1;
            while (index < countArgs) {
                String stringOfIndex = args[index];
                index++;
                int id = Integer.parseInt(stringOfIndex);
                if (id > 0) {
                    Person person = allPeople.get(id);
                    person.setSex(null);
                    person.setName(null);
                    person.setBirthDay(null);
                    allPeople.set(id, person);
                }
            }
        }
        if (args[0].equals("-i")) {
            int index = 1;
            while (index < countArgs) {
                String stringOfIndex = args[index];
                index++;
                int id = Integer.parseInt(stringOfIndex);
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
        }
    }
}
