package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        String max_count = reader.readLine();
        int N = Integer.parseInt(max_count);

        int count = 0;

        int n1 = 0;
        //напишите тут ваш код
        if (N == 1) {
            maximum = Integer.parseInt(reader.readLine());
        }else {
            n1 = Integer.parseInt(reader.readLine());
            while (count < N - 1) {

                maximum = Integer.parseInt(reader.readLine());

                maximum = (n1 > maximum)? n1 : maximum;
                n1 = maximum;
                count++;
            }

        }

        System.out.println(maximum);
    }
}
