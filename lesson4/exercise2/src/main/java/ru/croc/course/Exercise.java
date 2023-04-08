package ru.croc.cource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {
    /**
     * Метод, возвращающий мапу с ключём в виде имени автора и значением в виде коэффицента
     * @param mas Массив с элементами вида "<Название статьи>;<Имя автора>;<Текст статьи>"
     * @return Мап с ключём в виде имени автора и значением в виде коэффицента
     */
    public Map<String, Double> mainFunction(List<String> mas) {
        Map<String, Double> resultDict = new HashMap<>();

        for (String element : mas) {
            String[] elementsMas = element.split(";");

            String[] namesWordsMas = elementsMas[0]
                    .replaceAll("[^A-Z^a-z^а-я^А-Я^ ]", "")
                    .toLowerCase()
                    .split(" ");

            String author = elementsMas[1];

            String[] textsWordsMas = elementsMas[2]
                    .replaceAll("[^A-Z^a-z^а-я^А-Я^ ]", "")
                    .toLowerCase()
                    .split(" ");

            double currentCoefficient = getCoefficient(namesWordsMas, textsWordsMas);

            if (resultDict.containsKey(author)) {
                double previousCoefficient = resultDict.get(author);
                currentCoefficient = (currentCoefficient + previousCoefficient) / 2;
            }

            resultDict.put(author, currentCoefficient);
        }

        return resultDict;
    }


    /**
     * Вспомогательный метод, находящий значение коэффициента по статьи
     * @param namesWordsMas Массив со словами из названия статьи
     * @param textsWordsMas Массив со словами из текста статьи
     * @return Коэффициент
     */
    private double getCoefficient(String[] namesWordsMas, String[] textsWordsMas) {
        double count = 0;
        for (String namesWord : namesWordsMas) {
            for (String textsWord : textsWordsMas) {
                if (namesWord.equals(textsWord)) {
                    count++;
                }
            }
        }

        return count / textsWordsMas.length * 100;
    }
}
