package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws IOException {

        String sdate = "MAY 1 2013";

        System.out.println(isDateOdd(sdate));
    }

    public static boolean isDateOdd(String date)
    {
        Date currentTime = new Date(date);
        Date startTime = new Date();
        startTime.setYear(currentTime.getYear());
        startTime.setDate(1);

        int msDelay = 24*60*60*1000;
        int dayCount = (int)((currentTime.getTime() - startTime.getTime()) / msDelay);
        if (dayCount % 2 == 0)
            return false;
        else
            return true;
    }
}

