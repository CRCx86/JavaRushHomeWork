package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    static  String bTag = "";
    static Stack<Integer> integerStack = new Stack<>();
    static Map<Integer, String> linkedHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        String string;
        String buffer = "";

        bTag = "" + args[0];
        Integer countIndex = 0;

        while ((string = fileBufferedReader.readLine())!= null) {
            buffer += string;
        }

        indexMap(buffer, countIndex);


        fileBufferedReader.close();

    }

    public static void indexMap(String string, Integer countIndex) {

        int pos = 0;
        int tagLength = bTag.length();
        while (true) {
            int findPos = string.indexOf(bTag, pos);
            if (findPos == -1) break;

            if (string.substring(findPos - 1, findPos + tagLength).equals("<"+bTag)) {
                integerStack.push(findPos - 1);
            }

            if (string.substring(findPos - 1, findPos + tagLength).equals("/"+bTag)) {
                int index = integerStack.pop();
                linkedHashMap.put(index, string.substring(index, findPos + tagLength + 1));
            }
            pos = findPos + 1;
        }

        Map<Integer, String> integerStringMap = new TreeMap<>(linkedHashMap);

        for (Map.Entry entry : integerStringMap.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
