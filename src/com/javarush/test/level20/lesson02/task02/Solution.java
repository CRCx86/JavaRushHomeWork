package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.print(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            for (User user : users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.isMale());
                printWriter.println(user.getBirthDate().getTime());
                printWriter.println(user.getCountry());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < count; i++) {
                User user = new User();
                user.setFirstName(bufferedReader.readLine());
                user.setLastName(bufferedReader.readLine());
                user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                Date date = new Date();
                date.setTime(Long.parseLong(bufferedReader.readLine()));
                user.setBirthDate(date);
                user.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                users.add(user);
            }
        }
    }
}
