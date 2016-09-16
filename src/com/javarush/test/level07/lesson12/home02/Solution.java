package com.javarush.test.level07.lesson12.home02;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> buffer = new ArrayList<String>();
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++){
            arrayList.add(reader.readLine());
        }

        for (int i = 0; i < M; i++){
            buffer.add(arrayList.get(i));
        }

        for (int i = 0, j = 0; i < M; i++){
            arrayList.remove(j);
        }


        for (int i = 0; i < buffer.size(); i++){
            arrayList.add(buffer.get(i));
        }

        for (String s : arrayList){
            System.out.println(s);
        }
    }
}
