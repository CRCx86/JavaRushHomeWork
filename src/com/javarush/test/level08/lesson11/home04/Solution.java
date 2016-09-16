package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум

        int min = array.get(0);
        for (Integer anArray : array) {
            if (anArray < min) min = anArray;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        int N = Integer.parseInt(reader.readLine());
        int count = 0;
        while(count < N) {
            String str = reader.readLine();
            integerList.add(Integer.parseInt(str));
            count++;
        }

        return integerList;
    }
}
