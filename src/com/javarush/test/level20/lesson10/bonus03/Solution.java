package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList = new ArrayList<>();
        HashMap<String, Word> hashMap = new HashMap<>();

        for (String string : words) {

            if (string != null && string.length() > 0 && !string.equals(" ")) {
                char[] bufferChars = string.toCharArray();

                for (int i = 0; i < crossword.length; i++) {
                    for (int j = 0; j < crossword[i].length; j++) {

                        if (crossword[i][j] == bufferChars[0]) {

                            if (bufferChars.length == 1) {
                                Word word = new Word(String.valueOf(bufferChars));
                                word.setStartPoint(j, i);
                                word.setEndPoint(j, i);
                                hashMap.put(String.valueOf(bufferChars), word);
                                break;
                            }

                            for (int i1 = -1; i1 <= 1; i1++) {
                                for (int j1 = -1; j1 <= 1; j1++) {

                                    try {

                                        if (crossword[i + i1][j + j1] == bufferChars[1]) {

                                            if (i1 < 0 && j1 < 0) { // диагональ назад-вверх
                                                int endX = i - (bufferChars.length - 1);
                                                int endY = j - (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }

                                            }

                                            if (i1 > 0 && j1 > 0) { // диагональ вниз-вперед
                                                int endX = i + (bufferChars.length - 1);
                                                int endY = j + (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 > 0 && j1 < 0) { // диагональ вниз-назад
                                                int endX = i + (bufferChars.length - 1);
                                                int endY = j - (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 < 0 && j1 > 0) { // диагональ вверх-вперед
                                                int endX = i - (bufferChars.length - 1);
                                                int endY = j + (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 == 0 && j1 < 0) { // влево
                                                int endX = i;
                                                int endY = j - (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 == 0 && j1 > 0) { // вправо
                                                int endX = i;
                                                int endY = j + (bufferChars.length - 1);

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 > 0 && j1 == 0) { // вниз
                                                int endX = i + (bufferChars.length - 1);
                                                int endY = j;

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }

                                            if (i1 < 0 && j1 == 0) { // вверх
                                                int endX = i - (bufferChars.length - 1);
                                                int endY = j;

                                                int count = 1;
                                                if (endX >= 0 && endY >= 0) {

                                                    if (isTrueChar(crossword, bufferChars, i, j, i1, j1, count)) {
                                                        Word word = new Word(String.valueOf(bufferChars));
                                                        word.setStartPoint(j, i);
                                                        word.setEndPoint(endY, endX);
                                                        hashMap.put(String.valueOf(bufferChars), word);
                                                        break;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }
                                        }

                                    } catch (ArrayIndexOutOfBoundsException exception) {
                                        continue;
                                    }
                                }
                            }

                        }
                    }

                }
            }

        }

        for (Map.Entry<String, Word> pair : hashMap.entrySet()) {
            wordList.add(pair.getValue());
        }

        return wordList;
    }

    public static boolean isTrueChar(int[][] crossword, char[] bufferChars, int i, int j, int i1, int j1, int count) {

        while (i >= 0 && j >= 0 && count < bufferChars.length) {

            char ch = (char) crossword[i + i1][j + j1];
            char buff = bufferChars[count];

            if (ch == buff) {

                count++;
                i += i1;
                j += j1;

            } else {

                return false;

            }
        }

        if (count == bufferChars.length) {
            return true;
        }else {
            return false;
        }
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
