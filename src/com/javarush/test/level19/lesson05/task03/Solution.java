package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filebufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");

        String string;
        while ((string = filebufferedReader.readLine())!= null) {
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()){
                fileBufferedWriter.write(matcher.group().toString() + " ");
                fileBufferedWriter.flush();
            }
        }

        bufferedReader.close();
        filebufferedReader.close();
        fileBufferedWriter.close();

    }
}
