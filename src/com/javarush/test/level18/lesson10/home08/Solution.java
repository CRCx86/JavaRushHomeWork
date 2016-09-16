package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string;
        while (!((string = bufferedReader.readLine()).equals("exit"))) {
            new ReadThread(string).start();
        }

        System.out.println(resultMap);
        bufferedReader.close();
    }

    public static class ReadThread extends Thread {

        private FileInputStream fileInputStream;
        private String fileName;
        private Map<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) {
            //implement constructor body

            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                addToMap();
            } catch (IOException e) {

            }
        }

        private void readFileBytes() throws IOException {
            while (fileInputStream.available() > 0) {
                int bytes = fileInputStream.read();
                if (map.containsKey(bytes)){
                    int value = map.get(bytes);
                    map.put(bytes, ++value);
                } else {
                    map.put(bytes, 1);
                }
            }


        }

        private int getLastKeyMap() {

            List list = new ArrayList(map.entrySet());

            Collections.sort(list, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Map.Entry e1 = (Map.Entry) o1;
                    Map.Entry e2 = (Map.Entry) o2;
                    Comparable c1 = (Comparable) e1.getValue();
                    Comparable c2 = (Comparable) e2.getValue();
                    return c1.compareTo(c2);
                }
            });

            Map.Entry m = (Map.Entry) list.get(list.size() - 1);

            return (int) m.getKey();
        }

        public synchronized void addToMap() throws IOException {
            fileInputStream = new FileInputStream(fileName);
            if (fileInputStream.available() > 0) {
                readFileBytes();
                int key = getLastKeyMap();

                resultMap.put(fileName, key);
            }
            fileInputStream.close();
        }
    }
}
