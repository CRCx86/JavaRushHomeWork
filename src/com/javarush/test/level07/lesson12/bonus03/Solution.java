package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
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

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        int l = 0; int r = array.length - 1;
        qsort(array, l, r);

    }

    public static void qsort(int[] array, int l, int r){
        int i = l; //левая граница
        int j = r; // правая граница
        int x = l - (l - r) / 2; // опорный элемент

        while (i <= j){
            while (array[i] > array[x]){
                i++;
            }
            while (array[j] < array[x]){
                j--;
            }

            if (i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            if (l < j)
                qsort(array, l, j);

            if (i < r)
                qsort(array, i, r);

        }
    }
}
