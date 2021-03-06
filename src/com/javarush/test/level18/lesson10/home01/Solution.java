package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int count = 0;
        while (fileInputStream.available() > 0) {
            int bit = fileInputStream.read();
            if (bit >= 65 && bit <= 90) {
                count++;
            }

            if (bit >= 97 && bit <= 122) {
                count++;
            }
        }

        System.out.println(count);
        fileInputStream.close();
    }
}
