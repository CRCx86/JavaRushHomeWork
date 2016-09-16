package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filebufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));

        //Pattern pattern = Pattern.compile("\\bworld\\b", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("\\bworld\\b");

        String string;
        int count = 0;
        while ((string = filebufferedReader.readLine())!= null) {
            Matcher m = pattern.matcher(string);
            while (m.find()) {
                count++;
            }
        }

        System.out.println(count);

        filebufferedReader.close();
        bufferedReader.close();

    }
}
