package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            throw new IllegalArgumentException();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));

        String string = args[0];

        String line;
        while ((line = fileBufferedReader.readLine()) != null) {
            String[] tmp = line.split(" ");

            if (string.equals(tmp[0])) {
                System.out.println(line);
                break;
            }
        }

        bufferedReader.close();
        fileBufferedReader.close();
    }
}
