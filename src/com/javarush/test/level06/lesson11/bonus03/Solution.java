package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < 5; i++){
            String s = reader.readLine();
            count = Integer.parseInt(s);
            a.add(count);
        }
        Collections.sort(a);
        for(int s1 : a){
            System.out.println(s1);
        }
        System.out.println();
    }

}
