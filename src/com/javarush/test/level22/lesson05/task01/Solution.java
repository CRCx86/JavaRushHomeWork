package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException {

        int to = 0;
        int from = 0;
        int index = 0;
        String result = "";

        if(string == null || string.isEmpty())
        {
            throw new TooShortStringException();
        }

        to = string.indexOf(" ", index) + 1;

        if (to > 0) {

            for (int i = 0; i < 4; i++) {
                from = string.indexOf(" ", from) + 1;
                if (from == 0) { throw new TooShortStringException(); }
            }

            String buff[];
            if (from < string.length() - 1) {
                buff = string.substring(from, string.length()).split(" ");
                result = string.substring(to, from) + buff[0];
            } else {
                result = string.substring(to, from);
            }

        }else {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends Exception {

    }
}
