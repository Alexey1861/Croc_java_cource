package ru.croc.course;

import ru.croc.course.support.Employee;

import java.util.*;

/**
 * Класс с методами решающими первое упражнение
 */
public class Exercise {
    /**
     * Метод, разделяющий сотрудников по организациям
     * @param employeesList Список с сотрудниками
     * @return Мапа с ключём в виде руководителя и значением в виде списка с его сотрудниками
     */
    public Map<Employee, List<Employee>> separateByManagers(List<Employee> employeesList) {
        Map<Employee, List<Employee>> resultDict = new HashMap<>();

        for (Employee employee : employeesList) {
            Employee manager = employee.getManager();
            if (resultDict.containsKey(manager)) {
                List<Employee> mas = resultDict.get(manager);
                mas.add(employee);
            } else {
                List<Employee> mas = new ArrayList<>();
                mas.add(employee);
                resultDict.put(manager, mas);
            }
        }

        return resultDict;
    }


    /**
     * Метод, сортирующий руководителей по количеству сотрудников и имени
     * @param infoDict Результат работы метода separateByManagers
     * @return Отсортированный по возрастанию список с руководителями
     */
    public List<Employee> getSortedManagersList(Map<Employee, List<Employee>> infoDict) {
        Map<Employee, Integer> newInfoDict = new HashMap<>();

        for (var element : infoDict.entrySet()) {
            var key = element.getKey();
            var newValue = element.getValue().size();
            newInfoDict.put(key, newValue);
        }

        List<Employee> sortedManagersList = sortManagers(newInfoDict);

        return sortedManagersList;
    }


    /**
     * Сортировка
     * @param dict Преобразовання мапа с ключём в виде руководителя и значением в виде количества работников
     * @return Отсортированный список руководителей
     */
    private List<Employee> sortManagers(Map<Employee, Integer> dict) {
        List<Map.Entry<Employee, Integer>> mas = new ArrayList<>(dict.entrySet());

        for (int i = 0; i < mas.size() - 1; i++) {
            for (int j = i + 1; j < mas.size(); j++) {
                var elementI = mas.get(i);
                var elementJ = mas.get(j);

                Integer valueI = elementI.getValue();
                Integer valueJ = elementJ.getValue();

                String nameI = elementI.getKey().getName();
                String nameJ = elementJ.getKey().getName();

                if (valueI.compareTo(valueJ) > 0) {
                    mas.set(i, elementJ);
                    mas.set(j, elementI);
                } else if (valueI.compareTo(valueJ) == 0) {
                    if (nameI.compareTo(nameJ) > 0) {
                        mas.set(i, elementJ);
                        mas.set(j, elementI);
                    }
                }
            }
        }

        List<Employee> newMas = new ArrayList<>();
        for (var element : mas) {
            newMas.add(element.getKey());
        }

        return newMas;
    }

}
