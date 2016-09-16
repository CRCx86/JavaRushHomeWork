package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream inputStream = new FileInputStream(string);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            int value = 0;
            if (hashMap.containsKey(data)) {
                value = hashMap.get(data);
                value++;
                hashMap.put(data, value);
            }else {
                hashMap.put(data, value);
            }
        }

        int min = (int) hashMap.values().toArray()[0];
        for(Map.Entry entry : hashMap.entrySet()) {
            int value = (int) entry.getValue();
            if (value < min) {
                min = value;
            }
        }

        for (Map.Entry entry : hashMap.entrySet()) {
            int value = (int) entry.getValue();
            if (value == min) {
                System.out.println(entry.getKey());
            }
        }

        inputStream.close();
    }
}
