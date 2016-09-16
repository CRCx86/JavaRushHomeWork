package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        String string = "";
        int bytes = 0;
        while (fileInputStream.available() > 0) {
            bytes = fileInputStream.read();
            if (bytes == 32) {
                arrayList.add((int) Math.round(Float.parseFloat(string)));
                string = "";
                continue;
            }
            char ch = (char) bytes;
            string += ch;
        }
        arrayList.add((int) Math.round(Float.parseFloat(string)));

        for (Integer integer : arrayList) {
            int buffer = (int) integer;
            fileOutputStream.write((buffer + " ").getBytes());
        }

        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
