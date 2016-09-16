package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> listInteger = new ArrayList<>();
        int[] a = new int[5];
        int[] b = new int[2];
        int[] c = new int[4];
        int[] d = new int[7];
        int[] e = new int[0];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)Math.random()*5;
        }
        listInteger.add(a);
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)Math.random()*5;
        }
        listInteger.add(b);
        for (int i = 0; i < c.length; i++) {
            c[i] = (int)Math.random()*5;
        }
        listInteger.add(c);
        for (int i = 0; i < d.length; i++) {
            d[i] = (int)Math.random()*5;
        }
        listInteger.add(d);
        listInteger.add(e);

        return listInteger;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
