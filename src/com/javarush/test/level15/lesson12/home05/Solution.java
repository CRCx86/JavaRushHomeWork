package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/
import java.util.Objects;

public class Solution {
    Solution(){}

    Solution(Objects objects) {}

    Solution(Objects objects, Objects objects1){}

    protected Solution(Character number){}

    protected Solution(Short objects) {}

    protected Solution(Character objects, Short objects1){}

    public Solution(Integer number){}

    public Solution(Float objects) {}

    public Solution(Integer objects, Float objects1){}

    private Solution(int n){}

    private Solution(int n, char c){}

    private Solution(char c){}

}

