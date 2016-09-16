package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        String stringDate1 = bufferedReader.readLine();

        Date date1 = new Date(stringDate1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, YYYY", Locale.ENGLISH);
        System.out.println(simpleDateFormat.format(date1).toUpperCase());
    }
}
