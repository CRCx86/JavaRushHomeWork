package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        if (args.length >= 2) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

            String string = "";
            while ((string = bufferedReader.readLine())!=null) {
                String buff = new String(string.getBytes(), "UTF-8");
                String buffer = new String(buff.getBytes("Windows-1251"));
                bufferedWriter.write(buffer);
            }

            bufferedWriter.close();
            bufferedReader.close();
        }
    }
}
