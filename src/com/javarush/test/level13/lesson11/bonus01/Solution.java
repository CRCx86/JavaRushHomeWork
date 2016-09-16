package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String string = "";

        while (true) {

            string = fileBufferedReader.readLine();
            if (string == null) break;
            int in1 = Integer.parseInt(string);

            if (in1 % 2 == 0) {
                arrayList.add(in1);
            }
        }

        Collections.sort(arrayList);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        bufferedReader.close();
        fileBufferedReader.close();
    }
}
