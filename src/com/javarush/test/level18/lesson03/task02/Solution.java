package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream inputStream = new FileInputStream(string);
        int max = inputStream.read();
        while (inputStream.available() > 0) {
            int data = inputStream.read();

            if (data < max) {
                max = data;
            }

        }
        System.out.println(max);

        inputStream.close();
    }
}
