package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException {
        System.out.print((char)c);
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

        System.out.print(String.valueOf(cbuf).substring(off, off + len));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {

        System.out.print(str.substring(off, off + len));
        super.write(str, off, len);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str);
    }
}
