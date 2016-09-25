package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0)
            return;

        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        String string;
        while ((string = fileBufferedReader.readLine())!= null) {
            Pattern p = Pattern.compile("^[a-z0-9]$");
            Matcher m = p.matcher(string);

            if (m.find()) {
                fileBufferedWriter.write(m.group() + " ");
            }
            fileBufferedWriter.flush();
        }

        fileBufferedReader.close();
        fileBufferedWriter.close();
    }
}
