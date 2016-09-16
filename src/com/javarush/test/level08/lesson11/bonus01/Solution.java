package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringReader = bufferedReader.readLine();

        Map<String, Integer> mapMonth = new HashMap<>();

        mapMonth.put("January", Calendar.JANUARY);
        mapMonth.put("February", Calendar.FEBRUARY);
        mapMonth.put("March", Calendar.MARCH);
        mapMonth.put("April", Calendar.APRIL);
        mapMonth.put("May", Calendar.MAY);
        mapMonth.put("June", Calendar.JUNE);
        mapMonth.put("July", Calendar.JULY);
        mapMonth.put("August", Calendar.AUGUST);
        mapMonth.put("September", Calendar.SEPTEMBER);
        mapMonth.put("October", Calendar.OCTOBER);
        mapMonth.put("November", Calendar.NOVEMBER);
        mapMonth.put("December", Calendar.DECEMBER);

        int Month = mapMonth.get(stringReader);
        System.out.println(stringReader + " is " + (Month + 1) + " month");


    }

}
