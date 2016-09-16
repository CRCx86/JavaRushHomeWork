package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Map<Character, Integer> characterByteMap = new HashMap<>();

        while (fileInputStream.available() > 0) {
            int bytes = fileInputStream.read();
            char ch = (char) bytes;
            if (characterByteMap.containsKey(ch)) {
                int bt = characterByteMap.get(ch);
                characterByteMap.put(ch, ++bt);
            } else {
                characterByteMap.put(ch, 1);
            }
        }

        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>();
        sortedMap.putAll(characterByteMap);

        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        fileInputStream.close();
    }
}
