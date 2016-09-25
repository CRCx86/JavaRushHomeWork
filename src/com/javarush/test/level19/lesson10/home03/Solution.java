package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException, IOException
    {

        if (args.length == 0)
            return;

        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(args[0].toString()));

        String string;
        while ((string = fileBufferedReader.readLine())!= null) {
            String[] strings = string.split(" ");

            Integer integer = strings.length;

            int year = Integer.parseInt(strings[integer - 1]);
            int month = Integer.parseInt(strings[integer - 2]);
            int day = Integer.parseInt(strings[integer - 3]);

            Calendar bdCalendar = new GregorianCalendar();
            bdCalendar.set(year, month - 1, day);
            String name = "";
            for (Integer i = 0; i < integer - 3; i++) {
                name += strings[i] + " ";
            }

            PEOPLE.add(new Person(name.trim(), bdCalendar.getTime()));
        }

        fileBufferedReader.close();
    }

}
