package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static Map<String, String> resultMap = new HashMap<>();
    public static List<String> resultIdArray = new ArrayList<>();
    public static BufferedReader fileBufferedReader = null;
    public static BufferedWriter fileBufferedWriter = null;


    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            throw new IllegalArgumentException();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();


        if (args[0].equals("-u")) {
            // -- update string
            fileBufferedReader = new BufferedReader(new FileReader(fileName));
            initResultMap();
            fileBufferedReader.close();
            updateMap(args);
            fileBufferedWriter = new BufferedWriter(new FileWriter(fileName));
            updateIDFile();
            fileBufferedWriter.close();
        }

        if (args[0].equals("-d")) {
            // -- delete string
            fileBufferedReader = new BufferedReader(new FileReader(fileName));
            initResultMap();
            fileBufferedReader.close();
            updateMap(args);
            fileBufferedWriter = new BufferedWriter(new FileWriter(fileName));
            deleteIDFile(args[1]);
            fileBufferedWriter.close();
        }

        bufferedReader.close();

    }

    public static void initResultMap() throws IOException {

        String buffer;
        while ((buffer = fileBufferedReader.readLine())!= null) {
            resultMap.put(getID(buffer), parseValue(buffer));
            resultIdArray.add(getID(buffer));
        }

    }

    public static String getID(String string) {

        String result = "";
        char[] chars = string.toCharArray();

        if (chars[0] == '\uFEFF') {
            result = string.substring(1, 9);
        }
        else {
            result = string.substring(0, 8);
        }
        return result;
    }

    public static Integer parseID(String string) {

        Integer result = 0;
        String buffer = "";
        String stringBuffer;
        char[] chars = string.toCharArray();

        if (chars[0] == '\uFEFF') {
            stringBuffer = string.substring(1, chars.length);
        }
        else {
            stringBuffer = string.substring(0, chars.length);
        }

        chars = stringBuffer.toCharArray();
        for (char c : chars) {
            if (c == '\uFEFF' || c == ' ')
                continue;
            buffer += c;
        }
        try {
            result = Integer.parseInt(buffer);
        }catch (Exception e) {
            result = -1;
        }

        return result;
    }

    public static String parseValue(String string) {

        String result = "";
        char[] chars = string.toCharArray();

        if (chars[0] == '\uFEFF') {
            result = string.substring(9, string.length());
        }
        else {
            result = string.substring(8, string.length());
        }
        return result;
    }

    public static void updateMap(String[] chars) {

        String buffer ="";

        if (chars.length > 2) {

            for (int i = 2; i < chars.length - 2; i++) {
                buffer += chars[i] + " ";
            }

            String productName = buffer;
            String price = chars[chars.length - 2];
            String quantity = chars[chars.length - 1];

            int pN = productName.length();
            if (pN > 0) {
                for (int i = 0; i < 30 - pN; i++) {
                    productName += " ";
                }

                productName = productName.substring(0, 30);
            }

            int p = price.length();
            if (p > 0) {
                for (int i = 0; i < 8 - p; i++) {
                    price += " ";
                }
            }

            int q = quantity.length();
            if (q > 0) {
                for (int i = 0; i < 4 - q; i++) {
                    quantity += " ";
                }
            }

            buffer = productName + price + quantity;
        }

        Integer ID = parseID(chars[1]);

        if (ID != -1) {
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                String currentId = entry.getKey();
                String currentValue = entry.getValue();

                if (ID.toString().equals(currentId.trim())) {
                    resultMap.put(currentId, buffer);
                }else {
                    resultMap.put(currentId, currentValue);
                }
            }
        }
    }


    public static void updateIDFile() throws IOException {

        for (String currentID : resultIdArray) {
            String currentValue = resultMap.get(currentID);

            String result = currentID;
            if (currentID.length() < 8) {
                for (int i = 0; i < 8 - currentID.length(); i++)
                    result += " ";
            }

            fileBufferedWriter.write(result+currentValue);
            fileBufferedWriter.newLine();
        }
    }


    public static void deleteIDFile(String ID) throws IOException {

        for (String currentID : resultIdArray) {
            String currentValue = resultMap.get(currentID);

            if(ID.equals(currentID.trim())) {
                continue;
            }else {

                String result = currentID;
                if (currentID.length() < 8) {
                    for (int i = 0; i < 8 - currentID.length(); i++)
                        result += " ";
                }
                fileBufferedWriter.write(result+currentValue);
                fileBufferedWriter.newLine();
            }
        }
    }
}
