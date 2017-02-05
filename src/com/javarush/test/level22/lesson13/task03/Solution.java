package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static void main(String[] args)
    {
        System.out.println(checkTelNumber("+38-0501(234)567")); //false
        System.out.println(checkTelNumber("(150)-1234567"));    //true
        System.out.println(checkTelNumber("+-3805512345-67"));  //true
        System.out.println(checkTelNumber("050123-4567"));      //true
        System.out.println(checkTelNumber("+38(050)123-45-67"));//true
        System.out.println(checkTelNumber("050123456"));        //false
        System.out.println(checkTelNumber("+38-(050)1234567")); //false
        System.out.println(checkTelNumber("+38((050)1234567")); //false
        System.out.println(checkTelNumber("+5(0--5)1234567"));  //false
        System.out.println(checkTelNumber("7-4-4123689-5"));    //false
        System.out.println(checkTelNumber("1-23456789-0"));     //true
        System.out.println(checkTelNumber("+380-51202(345)-7"));//false
        System.out.println(checkTelNumber("050ххх4567"));       //false
        System.out.println(checkTelNumber("050123456"));        //false
        System.out.println(checkTelNumber("+313450--531202"));  //false
        System.out.println(checkTelNumber("+38051202(345)7"));  //true
        System.out.println(checkTelNumber("-380512023457"));    //true и делал чтобы было false, решение не проходит((
        System.out.println();

        System.out.println("+380501234567 "+ checkTelNumber("+380501234567"));              //true
        System.out.println("+38(050)1234567 "+ checkTelNumber("+38(050)1234567"));          //true
        System.out.println("+38050123-4567 "+ checkTelNumber("+38050123-4567"));            //true
        System.out.println("0501234567 "+ checkTelNumber("0501234567"));                    //true
        System.out.println("+38)050(1234567 "+ checkTelNumber("+38)050(1234567"));          //false
        System.out.println("+38(050)1-23-45-6-7 "+ checkTelNumber("+38(050)1-23-45-6-7"));  //false
        System.out.println("050ххх4567 "+ checkTelNumber("050ххх4567"));                    //false
        System.out.println("050123456 "+ checkTelNumber("050123456"));                      //false
        System.out.println("1 "+ checkTelNumber("1"));                                      //false
        System.out.println("null "+ checkTelNumber(null));                                  //false
    }

    public static boolean checkTelNumber(String telNumber) {

        boolean result = false;

        if (telNumber == null) {
            result = false;
            return result;
        }

        if (telNumber.matches("^\\+.*")) {
            if (telNumber.replaceAll("\\D", "").length() == 12)
                result = telNumber.matches("^(\\+)*\\d*(\\(?\\d{3}\\)?)?\\d*((-\\d+)?)?(\\d+)?((-\\d+)?)?(\\d+)?$");
        }
        if (telNumber.matches("^\\d.*") || (telNumber.matches("\\(.*"))) {
            if (telNumber.replaceAll("\\D", "").length() == 10)
                result = telNumber.matches("^(\\+)*\\d*(\\(?\\d{3}\\)?)?\\d*((-\\d+)?)?(\\d+)?((-\\d+)?)?(\\d+)?$");
        }

        return result;
    }
}
