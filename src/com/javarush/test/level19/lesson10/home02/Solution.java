package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0)
            return;

        Map<String, Double> stringDoubleMap = new HashMap<>();

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

        SortedMap<String, Double> sortedMap = new TreeMap<>();

        sortedMap.putAll(stringDoubleMap);

        Double max = Double.MIN_VALUE;
        for (Map.Entry entry : sortedMap.entrySet()) {
            max = Math.max(max, (Double) entry.getValue());
        }

        fileBufferedReader.close();

        for (Map.Entry entry : sortedMap.entrySet()) {
            if (entry.getValue().equals(max))
                System.out.println(entry.getKey());
        }
    }
}
