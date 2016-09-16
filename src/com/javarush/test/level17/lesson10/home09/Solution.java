package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                String string = forRemoveLines.get(i);
                if (allLines.contains(string)) {
                    allLines.remove(string);
                }
            }
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();

        BufferedReader fileBufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        String stringBuff = new String("");

        while ((stringBuff = fileBufferedReader1.readLine())!=null) {
            allLines.add(stringBuff);
        }

        String fileName2 = bufferedReader.readLine();
        BufferedReader fileBufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));
        stringBuff = "";
        while ((stringBuff = fileBufferedReader2.readLine())!=null) {
            forRemoveLines.add(stringBuff);
        }

        try {
            new Solution().joinData();
        }catch (CorruptedDataException ce) {

        }

    }


}