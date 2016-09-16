package com.javarush.test.level04.lesson16.home02;

import com.sun.org.apache.xpath.internal.operations.*;

import java.io.*;
import java.lang.String;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s1  = buff.readLine();
        int n1 = Integer.parseInt(s1);
        String s2  = buff.readLine();
        int n2 = Integer.parseInt(s2);
        String s3  = buff.readLine();
        int n3 = Integer.parseInt(s3);


        int min2 = min1(n1, min1(n2,n3));
        int max2 = max1(n1, max1(n2,n3));

        if (n1 != min2 && n1 != max2) {
            System.out.print(n1);
        }

        if (n2 != min2 && n2 != max2) {
            System.out.print(n2);
        }

        if (n3 != min2 && n3 != max2) {
            System.out.print(n3);
        }


    }

    public static int min1 (int a, int b){
        if (a < b)
            return a;
        else
            return b;
    }

    public static int max1 (int a, int b){
        if (a > b)
            return a;
        else
            return b;
    }
}
