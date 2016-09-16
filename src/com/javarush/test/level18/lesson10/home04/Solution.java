package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(string);

        byte[] buffer = null;
        int count = 0;
        if (fileInputStream1.available() > 0) {
            buffer = new byte[fileInputStream1.available()];
            count = fileInputStream1.read(buffer);
        }

        fileInputStream1.close();
        FileOutputStream fileOutputStream1 = new FileOutputStream(string);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());

        if (fileInputStream2.available() > 0 && buffer != null) {
            byte[] buffer1 = new byte[fileInputStream2.available()];
            int count1 = fileInputStream2.read(buffer1);
            fileOutputStream1.write(buffer1, 0, count1);
            fileOutputStream1 = new FileOutputStream(string, true);
            fileOutputStream1.write(buffer, 0, count);

        }

        bufferedReader.close();
        fileInputStream2.close();
        fileOutputStream1.close();


    }
}
