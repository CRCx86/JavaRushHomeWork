package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);
        invert_m(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void invert_m(int[] array){

        int len = array.length;

        int k = len - 1;
        for (int i = 0; i < len / 2; i++){
            int buf = array[i];
            array[i] = array[k];
            array[k] = buf;
            k--;
        }
    }

    public static void sort(int[] array)
    {
        qsort1(array, 0, array.length - 1);
    }

    public static void qsort1(int[] array, int begin, int end)
    {
        //напишите тут ваш код
        int x = array[begin + (end - begin) / 2];
        int i = begin, j = end;

        do {
            while (array[i] < x) i++;
            while (array[j] > x) j--;

            if (i <= j)
            {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }

        } while (i <= j);

        if(i < end) qsort1(array, i, end);
        if(begin < j) qsort1(array, begin, j);
    }
}
