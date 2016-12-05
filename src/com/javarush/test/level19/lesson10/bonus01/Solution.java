package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filebufferedReader1 = new BufferedReader( new FileReader(bufferedReader.readLine()));
        BufferedReader filebufferedReader2 = new BufferedReader( new FileReader(bufferedReader.readLine()));

        List<String> stringListFile1 = new ArrayList<>();
        List<String> stringListFile2 = new ArrayList<>();

        String string = "";
        while ((string = filebufferedReader1.readLine()) != null) {
            stringListFile1.add(string.trim());
        }

        string = "";
        while ((string = filebufferedReader2.readLine())!=null) {
            stringListFile2.add(string.trim());
        }

        if (stringListFile1.size() >= stringListFile2.size())
        {
            for (int i = 0; i < stringListFile1.size(); i++)
            {
                int count = 0;
                if (stringListFile2.size() > 0)
                {
                    if (stringListFile1.get(i).equals(stringListFile2.get(count)))
                    {
                        lines.add(new LineItem(Type.SAME, stringListFile1.get(i)));
                        stringListFile2.remove(0);
                        continue;
                    }
                    count++;
                    if (stringListFile2.size() > 1) {
                        if (stringListFile1.get(i).equals(stringListFile2.get(count)))
                        {
                            lines.add(new LineItem(Type.ADDED, stringListFile2.get(0)));
                            stringListFile2.remove(0);
                            lines.add(new LineItem(Type.SAME, stringListFile1.get(i)));
                            stringListFile2.remove(0);
                        } else {
                            lines.add(new LineItem(Type.REMOVED, stringListFile1.get(i)));
                        }
                    }else
                    {
                        lines.add(new LineItem(Type.REMOVED, stringListFile1.get(i)));
                    }
                }
                else
                {
                    lines.add(new LineItem(Type.REMOVED, stringListFile1.get(i)));
                }

            }
            if (stringListFile2.size() > 0)
                for (int i = 0; i < stringListFile2.size(); i++)
                {
                    lines.add(new LineItem(Type.ADDED, stringListFile2.get(i)));
                }
        } else
        {
            for (int i = 0; i < stringListFile1.size(); i++)
            {
                int count = 0;
                if (stringListFile2.size() > 0)
                {
                    if (stringListFile1.get(i).equals(stringListFile2.get(count)))
                    {
                        lines.add(new LineItem(Type.SAME, stringListFile1.get(i)));
                        stringListFile2.remove(0);
                        continue;
                    }
                    count++;
                    if (stringListFile1.get(i).equals(stringListFile2.get(count)))
                    {
                        lines.add(new LineItem(Type.ADDED, stringListFile2.get(0)));
                        stringListFile2.remove(0);
                        lines.add(new LineItem(Type.SAME, stringListFile1.get(i)));
                        stringListFile2.remove(0);

                    } else
                    {
                        lines.add(new LineItem(Type.REMOVED, stringListFile1.get(i)));
                    }
                }
            }
            if (stringListFile2.size() > 0)
                for (int i = 0; i < stringListFile2.size(); i++)
                {
                    lines.add(new LineItem(Type.ADDED, stringListFile2.get(i)));
                }
        }

        bufferedReader.close();
        filebufferedReader1.close();
        filebufferedReader2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
