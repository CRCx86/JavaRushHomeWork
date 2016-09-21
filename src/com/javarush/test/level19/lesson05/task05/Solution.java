package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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

            String buffer = string.replaceAll("\\p{Punct}", "");

            fileBufferedWriter.write(buffer);
            fileBufferedWriter.flush();
        }

        bufferedReader.close();
        filebufferedReader.close();
        fileBufferedWriter.close();
    }
}
