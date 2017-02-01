package com.javarush.test.level22.lesson09.task03;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {

    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//
        String string = "", buff = "";
//
        while ((string = fileReader.readLine()) != null) {
            buff += string;
        }

        bufferedReader.close();
        fileReader.close();

        //buff = //"wm mw ks wk kw";
        //"Киев Нью-Йорк Амстердам Вена Мельбурн";
        //"ab ca aD bd db bc ba";
        //"Киев Нью-Йорк Амстердам Вена Мельбурн Амстердам Кама";
         //"Ardon Rasskazovo Yelets Yemanzhelinsk Verkhnyaya Verkhny Nakhodka Selo Nalchik Igarka Alexandrovsk Velsk Kinel Armavir Kirovsk Elektrostal Akhtubinsk Argun Nefteyugansk Abinsk Gatchina Naryan-Mar Oktyabrsky Kalininsk Karachev Arsenyev Ak-Dovurak Opochka Kamyshlov Kalachinsk Yeysk Klimovsk Ilansky Kamyshin Obluchye Kirovo-Chepetsk Olonets Khanty-Mansiysk Verkhnyaya Kholm Vereshchagino Sulin Naro-Fominsk Kizlyar Ramenskoye Oboyan Kadnikov Val Kholmsk Dalnerechensk Okulovka Kambarka Nesterov Okha Alagir Kalyazin Ivangorod Khadyzhensk Kandalaksha Rodniki Kasimov Nerekhta Kizel Elektrogorsk Yaransk Yermolino Taganrog Kirov Veliky Vesyegonsk Oblast Neryungri Yalutorovsk Gagarin Ardatov Raduzhny Obninsk Kem Karpinsk Kalach-na-Donu Reutov Saint Abdulino Kazan Makushino Naberezhnye Khimki Kholunitsa Magas Raychikhinsk Kalitva Kargopol Lakhdenpokhya Agryz Tura Kingisepp Lermontov Arkhangelsk Isilkul Navoloki Kirillov Yanaul Olyokminsk Kislovodsk Lebedyan Anadyr Artyomovsky Sergi Karabanovo Istra Narimanov Khasavyurt Nartkala Posad Vereya Inza Kachkanar Alexandrovsk-Sakhalinsky Veliky Klintsy Neman Kineshma Okhansk Ishim Kaluga Aksay Alzamay Zori Kirovsk Aldan Verkhoyansk Lesnoy Insar Kartaly Yaroslavl Adygeysk Labytnangi Kasli Aprelevka Leninsk Kirov Nazarovo Odintsovo Iskitim Kamenka Nadym Karachayevsk Elektrougli Orenburg Yeniseysk Kansk Yelabuga Safonovo Kirensk Innopolis Olenegorsk Alexeyevka Elista Kharabali Lakinsk Kaliningrad Yelnya Kashira Babayevo Khvalynsk Kamyzyak Kamensk-Uralsky Kharovsk Ochyor Kiselyovsk Yartsevo Talitsa Kargat Arsk Abaza Andreapol Lensk Tambov Kirsanov Oskol Yemva Achinsk Magnitogorsk Ogni Kodinsk Kizilyurt Ob Kirovgrad Khotkovo Omutninsk Knyaginino Langepas Alatyr Irkutsk Apsheronsk Makarov Kimovsk Engels Orekhovo-Zuyevo Artyom Angarsk Ladushkin Tagil Kamen Karasuk Yarovoye Makhachkala Vetluga Raduzhny Yershov Oryol Ishimbay Ipatovo Taldom Magadan Kirs Yegoryevsk Yasny Aleksin Yakhroma Oktyabrsk Kemerovo Kimry Kamennogorsk Makaryev Kedrovy Alexandrov Dalnegorsk Yakutsk Artyomovsk Kashin Yekaterinburg Verkhnyaya Khabarovsk Roshal Laishevo Almetyevsk Kogalym Aniva Katav-Ivanovsk Salda Omsk Vody Agidel Dagestanskiye Labinsk Yoshkar-Ola Kaspiysk Yadrin Karabulak Nelidovo Nerchinsk Lesosibirsk Aramil Neftekumsk Kataysk Kamensk-Shakhtinsky Kireyevsk Aleysk Revda Anzhero-Sudzhensk Samara Neftekamsk Apatity Anapa Leninsk-Kuznetsky Nazyvayevsk Onega Gadzhiyevo Alapayevsk Yefremov Yelizovo Klin Nazran Yessentuki Verkhneuralsk Dalmatovo Leninogorsk Ertil Lagan Arkadak Kaltan Yasnogorsk Venyov Irbit Malaya Verkhny Valday Kamen-na-Obi Valuyki Kirishi Khilok Kameshkovo Inta Amursk Chadan Velikiye Vishera Navashino Urengoy";
        //"Zitomir Moskva Achinsk Voronez Krasnoyarsk Kostroma Vilnus Sorsk Kishinev Abakan Kiev Norilsk Rovno Orel Lipesk Anapa";
        //"abc cde cdf cdo fa mno opr opq rm qsc";
        //"ab ca bd db bc ba";
        //"Zitomir Achinsk Voronez Krasnoyarsk Kostroma Vilnus Sorsk Kishinev Abakan Kiev Norilsk Rovno Orel Lipesk Anapa";
        //"a";
        //"ab ba";
        //"";

        String[] strings = buff.split(" ");

        StringBuilder result = getLine(strings);
        System.out.println(result);
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
            return new StringBuilder();

        if (words[0].equals("") && words.length == 1)
            return new StringBuilder(words[0]);

        if (words.length == 1) {
            return new StringBuilder(words[0]);
        }

        Graph graph = new Graph(words);
        StringBuilder stringBuilder = new StringBuilder();
        if (graph.vertexCount > 1) {
            graph.weightVertexes();
            stringBuilder = graph.dfs();
        }else if (graph.vertexCount == 1) {

            for (Vertex vertex : graph.getVertexList()) {
                stringBuilder.append(vertex.getName() + " ");
            }
        }

        return stringBuilder;
    }

    public static class Vertex {

        String name; // имя вершины
        Integer prev; // прыдущая вершина
        Integer next; // следующая вершина
        Integer weight;

        Vertex(String name) {
            this.name = name;
        }

        Vertex (String name, Integer prev, Integer next) {
            this.name = name;
            this.prev = prev;
            this.next = next;

        }

        public String getName()
        {
            return name;
        }

        public void setWeight(Integer weight)
        {
            this.weight = weight;
        }
    }

    public static class Graph {

        List<Vertex> vertexList; // список вершин
        Integer vertexCount;
        List<List<Integer>> matrix; //матрица смежности

        Graph(String... vertexes) {

            vertexList = new ArrayList<>();
            matrix = new ArrayList<>();

            for (String string : vertexes) {
                vertexList.add(new Vertex(string));
            }

            initMatrix();
            mergeSingleVertexes();

        }

        public void addVertex(String vertex) {
            vertexList.add(new Vertex(vertex));
        }

        public void initMatrix() {

            vertexCount = vertexList.size();

            matrix.clear();

            for (int i = 0; i < vertexCount; i++)
            {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < vertexCount; j++)
                {
                    if (vertexList.get(i).getName().toUpperCase().charAt(vertexList.get(i).getName().length() - 1)
                            == vertexList.get(j).getName().toUpperCase().charAt(0) && i != j)
                    {
                        list.add(1);
                    } else
                    {
                        list.add(0);
                    }
                }
                matrix.add(list);
            }

        }

        public void printVertexList() {

            for (Vertex vertex : vertexList)
            {
                System.out.print(vertex.getName() + " ");
            }

            System.out.println();

        }

        public void mergeSingleVertexes() {

            while (true)
            {
                int oldVertexCount = vertexCount;
                int in = -1, out = 0;
                for (int i = 0; i < vertexCount; i++)
                {
                    Integer sum = 0;
                    for (int j = 0; j < vertexCount; j++)
                    {
                        if (matrix.get(i).get(j) == 1)
                        {
                            sum += matrix.get(i).get(j);
                            out = j;
                        }
                    }

                    if (sum == 1)
                    {
                        in = i;
                        break;
                    }
                }

                if (in >= 0) {

                    String bufferIn = vertexList.get(in).getName();
                    String bufferOut = vertexList.get(out).getName();

                    String buffer = bufferIn + " " + bufferOut;
                    vertexList.set(out, new Vertex(buffer));

                    vertexList.remove(in);
                    vertexCount--;

                    initMatrix();

                }else {
                    break;
                }

                if(vertexCount  == 1) {
                    break;
                }
                if (vertexCount == oldVertexCount) {
                    break;
                }
            }

        }

        public List<Vertex> getVertexList()
        {
            return vertexList;
        }

        public Integer getVertexCount()
        {
            return vertexCount;
        }

        public List<List<Integer>> getMatrix()
        {
            return matrix;
        }

        public void weightVertexes() {
            for (int i = 0; i < vertexCount; i++) {
                int sum = 0;
                for (int j = 0; j < vertexCount; j++) {
                    sum += matrix.get(j).get(i);
                }
                vertexList.get(i).setWeight(sum);
            }

            for (int i = 0; i < vertexCount; i++) {
                int min = vertexList.get(i).weight;
                int min_i = i;
                Vertex minV = vertexList.get(i);
                for (int j = i + 1; j < vertexCount; j++) {
                    if (vertexList.get(j).weight < vertexList.get(i).weight) {
                        if (vertexList.get(j).weight < min) {
                            min = vertexList.get(j).weight;
                            min_i = j;
                        }
                    }
                }
                if (i != min_i) {
                    Vertex tmp =  vertexList.get(i);
                    vertexList.set(i, vertexList.get(min_i));
                    vertexList.set(min_i, tmp);
                }

            }

            initMatrix();
        }

        public StringBuilder dfs() {

            StringBuilder result = new StringBuilder();
            Boolean isBuild = false;
            List<Integer> integerList = new ArrayList<>();

            for (int i = 0; i < vertexCount; i++)
            {
                if (integerList.size() == vertexCount || isBuild) break;

                Stack<Integer> stack = new Stack<>();
                integerList.clear();

                stack.push(i);
                integerList.add(i);

                Integer start = 0, current = 0;
                Boolean hasNext = true;

                while (!stack.isEmpty()) {

                    if(isBuild) break;

                    if(hasNext)
                    {
                        start = 0;
                        current = stack.peek();
                    }
                    else {
                        start = stack.peek() + 1;
                        stack.pop();
                        if (stack.isEmpty())
                            break;
                        current = stack.peek();
                        integerList.remove(integerList.size() - 1);
                    }

                    Boolean isNext = false;
                    for (int j = start; j < vertexCount; j++) {
                        if (isBuild) break;
                        if (matrix.get(current).get(j) == 1) {
                            if (!integerList.contains(j))
                            {
                                integerList.add(j);
                                stack.push(j);
                                isNext = true;
                                if (integerList.size() == vertexCount)
                                    isBuild = true;
                                break;
                            }else {
                                isNext = false;
                            }
                        }
                    }
                    if (isNext) hasNext = true; else hasNext = false;
                }

                if (isBuild) {
                    for (int v = 0; v < integerList.size(); v++) {
                        result.append(vertexList.get(integerList.get(v)).getName() + " ");
                    }
                }
            }

            return result;
        }
    }

}
