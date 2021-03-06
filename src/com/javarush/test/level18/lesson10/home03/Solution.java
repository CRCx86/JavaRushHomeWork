package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(string, false);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(bufferedReader.readLine());

        while (fileInputStream2.available() > 0) {
            int bytes = fileInputStream2.read();
            fileOutputStream.write(bytes);
        }


        while (fileInputStream3.available() > 0) {
            int bytes = fileInputStream3.read();
            fileOutputStream.write(bytes);
        }

        bufferedReader.close();
        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
