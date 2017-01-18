package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        String string = "", buff = "";

        while ((string = fileReader.readLine()) != null) {
            buff += string;
            buff += " ";
        }

        StringBuilder stringBuilder = new StringBuilder(buff.trim());

        do {
            int index = stringBuilder.indexOf(" ");

            if (index > 0)
            {
                StringBuilder stringRev = new StringBuilder(stringBuilder.substring(0, index));

                int indexRev = stringBuilder.indexOf(String.valueOf(stringRev.reverse()), index + 1);

                if (indexRev > 0)
                {
                    Pair pair = new Pair(stringBuilder.substring(0, index), stringBuilder.substring(indexRev, indexRev + index));
                    if (!toContain(result, pair))
                    {
                        result.add(pair);
                        stringBuilder.delete(indexRev, indexRev + index);
                        stringBuilder.delete(0, index);
                        stringBuilder = new StringBuilder(stringBuilder.toString().trim());
                    } else {
                        stringBuilder.delete(indexRev, indexRev + index);
                        stringBuilder.delete(0, index);
                        stringBuilder = new StringBuilder(stringBuilder.toString().trim());
                    }
                } else
                {
                    stringBuilder.delete(0, index);
                    stringBuilder = new StringBuilder(stringBuilder.toString().trim());
                }
            } else {
                stringBuilder.delete(0, stringBuilder.length());
            }

        } while (stringBuilder.length()!=0);

        for (Pair p : result) {
            System.out.println(p.toString());
        }
    }

    public static boolean toContain(List<Pair> result, Pair pair) {

        for (Pair p : result) {

            if (p.first.equals(pair.first)) {
                return true;
            }
        }

        return false;

    }

    public static class Pair {
        String first;
        String second;

        Pair () {
            first = null;
            second = null;
        }

        Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
