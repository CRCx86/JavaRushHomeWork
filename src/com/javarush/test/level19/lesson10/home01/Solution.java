package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        SortedMap<String, Double> stringDoubleMap = new TreeMap<>();

        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(args[0].toString()));

        String string;
        while ((string = fileBufferedReader.readLine())!= null) {
            String[] strings = string.split(" ");
            Double aDouble = stringDoubleMap.get(strings[0]);

            if (aDouble == null) {
                stringDoubleMap.put(strings[0], Double.parseDouble(strings[1]));
            } else {
                stringDoubleMap.put(strings[0], Double.parseDouble(strings[1]) + aDouble);
            }
        }

        fileBufferedReader.close();

        for (Map.Entry entry : stringDoubleMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
