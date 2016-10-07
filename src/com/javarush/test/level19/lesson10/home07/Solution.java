package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0)
            return;

        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader fileBufferedReader = new BufferedReader(fileReader);
        BufferedWriter fileBufferedWriter = new BufferedWriter(fileWriter);

        String string = "";
        String result = "";
        while ((string = fileBufferedReader.readLine())!=null) {

            String[] buff = string.split("[\\p{Space}]");
            for (int i = 0; i < buff.length; i++) {
                if (buff[i].length() > 6) {
                    result += buff[i] + ",";
                }
            }
        }
        result = result.substring(0, result.length() - 1);
        fileBufferedWriter.write(result);

        fileBufferedReader.close();
        fileBufferedWriter.close();
        fileReader.close();
        fileWriter.close();
    }
}
