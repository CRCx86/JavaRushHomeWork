package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            throw new IllegalArgumentException();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));

        Integer maxIDString = 0;
        String buffer;
        while ((buffer = fileBufferedReader.readLine())!= null) {
            if (buffer.equals(""))
                continue;
            Integer currentID = getId(buffer);
            if (currentID != -1) {
                if (currentID > maxIDString) {
                    maxIDString = currentID;
                }
            }
        }

        fileBufferedReader.close();
        BufferedWriter fileBufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        String nextID = getNextId(maxIDString.toString());
        if (!nextID.equals("")) {
            String result = nextID + initFullString(args);
            fileBufferedWriter.write(result);
            fileBufferedWriter.newLine();
        }

        bufferedReader.close();
        fileBufferedWriter.close();

    }

    public static Integer getId(String string) {


        if (string.length() >= 8) {
            String buffer = "";
            char[] result = string.substring(0, 8).toCharArray();
            for (char c : result) {
                if (c == '\uFEFF' || c == ' ')
                    continue;
                buffer += c;
            }
            try {
                Integer integer = Integer.parseInt(buffer);
                return integer;
            } catch (Exception e) {
                return -1;
            }
        } else {
            return -1;
        }

    }

    public static String getNextId(String string) {

        String result = "";

        Integer integerId = 0;
        try {
            integerId = Integer.parseInt(string);
            integerId++;
        } catch (Exception e) {
            return "";
        }

        if (integerId > 99999999) {
            return "";
        }

        String resultID = integerId.toString();
        result = resultID;
        if (result.length() < 8) {
            for (int i = 0; i < 8 - resultID.length(); i++)
                result += " ";
        }

        return result.substring(0, 8);
    }

    public static String initFullString(String[] chars) {

        String result = "";
        String productName = "";
        String price = "";
        String quantity = "";

        final int productNameLength = 30;
        final int priceLength = 8;
        final int quantityLength = 4;

        if (chars[0].equals("-c")) {

            price = chars[chars.length - 2];
            quantity = chars[chars.length - 1];

            for(int i = 1; i < chars.length - 2; i++) {
                productName += chars[i] + " ";
            }


            for (int i = 0; i < productNameLength - 1; i++) {
                productName += " ";
            }

            productName = productName.substring(0, 30);

            int p = price.length();
            for (int i = 0; i < priceLength - p; i++) {
                price += " ";
            }

            int q = quantity.length();
            for (int i = 0; i < quantityLength - q; i++) {
                quantity += " ";
            }

            result = productName + price + quantity;
        }
        return result;
    }
}
