package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        int sum = 0;
        while (true) {

            s1 = buff.readLine();
            if (s1.equals("сумма"))
                break;
            else
                sum = sum + Integer.parseInt(s1);


        }

        System.out.print(sum);
    }
}
