package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {

            String s1 = buff.readLine();
            int n1 = Integer.parseInt(s1);
            count += n1;

            if (s1.equals("-1"))
                break;
        }
        System.out.print(count);

    }
}
