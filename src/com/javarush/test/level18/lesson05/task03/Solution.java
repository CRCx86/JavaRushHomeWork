package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream outputStream = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(bufferedReader.readLine());

        int sizeofFile = inputStream.available();
        if ( sizeofFile> 0) {
            if (sizeofFile % 2 != 0) {
                int s1 = sizeofFile / 2;
                byte[] buffer = new byte[s1 + 1];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);

                buffer = null;
                buffer = new byte[s1];
                count = inputStream.read(buffer);
                outputStream1.write(buffer, 0, count);
            } else {
                int s1 = sizeofFile / 2;
                byte[] buffer = new byte[s1];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
                count = inputStream.read(buffer);
                outputStream1.write(buffer, 0, count);
            }
        }

        bufferedReader.close();
        inputStream.close();
        outputStream.close();
        outputStream1.close();


    }
}
