package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name
Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = null;
        try {
            string = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int position = string.indexOf('?');
        String attributeSubString = string.substring(position + 1, string.length());
        String []lineAttributes = attributeSubString.split("&");

        position = 0;
        String attributeBehind = null, attributeAfter = null;
        String attributeObj = null;
        for (String s : lineAttributes) {
            position = s.indexOf('=');
            if (position >  0) {
                attributeBehind = s.substring(0, position);
                attributeAfter = s.substring(position + 1, s.length());
                if (attributeBehind.equals("obj")) {
                    attributeObj = attributeAfter;
                }
                System.out.print(attributeBehind + " ");
            }else {
                System.out.print(s + " ");
            }

        }

        System.out.println();

        if (attributeObj != null) {
            try {
                Double n = Double.parseDouble(attributeObj);
                if (n != null) {
                    double d = (double) n;
                    alert(d);
                }else {
                    alert(attributeObj);
                }
            } catch (NumberFormatException e) {
                alert(attributeObj);
            }

        }


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}