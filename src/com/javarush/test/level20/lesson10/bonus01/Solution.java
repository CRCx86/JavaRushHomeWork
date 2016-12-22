package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result = null;

        for (int i = 0; i < N; i++) {

            int count = i;
            int length = 0;

            while (count != 0) {
                count /= 10;
                length++;
            }

            count = i;
            long sum = 0;

            while (count != 0) {
                int rem = count % 10;
                int buff = 1;
                for (int i1 = 0; i1 < length; i1++) {
                    buff *= rem;
                }
                sum += buff;
                count /= 10;
            }

            if (i > 0) {
                if (sum == i) {
                    if (result == null) {
                        result = new int[1];
                        result[0] = i;
                    }else {
                        int[] tmp = new int[result.length + 1];
                        System.arraycopy(result, 0, tmp, 0, result.length);
                        tmp[tmp.length - 1] = i;
                        result = tmp;
                    }
                }
            }
        }

        return result;
    }
}
