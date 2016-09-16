package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s0 = buff.readLine();
        String s1  = buff.readLine();
        int n1 = Integer.parseInt(s1);
        String s2  = buff.readLine();
        int n2 = Integer.parseInt(s2);
        String s3  = buff.readLine();
        int n3 = Integer.parseInt(s3);

        System.out.println("Меня зовут " + s0);
        System.out.println("Я родился " + n3  + "."  + n2 + "." + n1);
    }
}
