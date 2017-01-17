package com.javarush.test.level22.lesson05.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {


    public static String getPartOfString(String string) throws TooShortStringException
    {
        String result = "";

        if (string == null || string.isEmpty() ) {
            throw new TooShortStringException();
        } else {
            try {
                int to = string.indexOf("\t");
                int from = string.indexOf("\t", to + 1);
                result = string.substring(to + 1, from);
            } catch (Exception e) {
                throw new TooShortStringException();
            }
        }

        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
