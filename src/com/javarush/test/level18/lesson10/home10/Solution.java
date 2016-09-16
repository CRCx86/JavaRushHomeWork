package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        String fileName = null;
        List<String> list = new ArrayList<>();
        while (!((string = bufferedReader.readLine()).equals("end"))){
            list.add(string);
            fileName = string;
        }

        Collections.sort(list);

        FileOutputStream fileOut = new FileOutputStream(fullFileName(fileName), true);
        for (String s : list) {
            FileInputStream fileIn = new FileInputStream(s);
            while (fileIn.available() > 0) {
                byte[] buffer = new byte[fileIn.available()];
                int count = fileIn.read(buffer);
                fileOut.write(buffer, 0, count);
            }
            fileIn.close();
        }

        fileOut.close();
        bufferedReader.close();

    }

    public static String fullFileName(String string) {

        int pos = string.indexOf("part");
        String subString = string.substring(0, pos - 1);

        return subString;
    }
}
