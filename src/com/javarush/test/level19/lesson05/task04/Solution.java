package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filebufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        String string;
        while ((string = filebufferedReader.readLine())!= null) {

            String buffer = string.replaceAll("\\.", "!");

            fileBufferedWriter.write(buffer);
            fileBufferedWriter.flush();
        }

        bufferedReader.close();
        filebufferedReader.close();
        fileBufferedWriter.close();
    }
}
