package org.example.first_excercies;

import org.example.first_excercies.support.Employee;

import java.util.*;

public class FirstExercise {
    public Map<Employee, List<Employee>> separateByManager(Employee[] employees) {
        Map<Employee, List<Employee>> managersDict = new HashMap<>();

        for (Employee employee : employees) {
            Employee manager = employee.getManager();
            if (managersDict.containsKey(manager)) {
                List<Employee> mas = managersDict.get(manager);
                mas.add(employee);
            } else {
                List<Employee> mas = new ArrayList<>();
                mas.add(employee);

                managersDict.put(manager, mas);
            }
        }

        return managersDict;
    }

    public List<Employee> getSortedManagersList(Employee[] employees) {
        Map<Employee, List<Employee>> managersDict = separateByManager(employees);

        Map<Employee, Integer> newManagersDict = new HashMap<>();
        for (Employee manager : managersDict.keySet()) {
            List<Employee> mas = managersDict.get(manager);
            Integer masSize = mas.size();

            newManagersDict.put(manager, masSize);
        }

        List<Employee> sortedManagersList = sortManagers(newManagersDict);

        return sortedManagersList;
    }

    private List<Employee> sortManagers(Map<Employee, Integer> managersDict) {
        List<Map.Entry<Employee, Integer>> mas = new ArrayList<>(managersDict.entrySet());
        for (int i = 0; i < mas.size() - 1; i++) {
            for (int j = i + 1; j < mas.size(); j++) {
                Map.Entry<Employee, Integer> elementI = mas.get(i);
                Map.Entry<Employee, Integer> elementJ = mas.get(j);

                Integer valueI = elementI.getValue();
                Integer valueJ = elementJ.getValue();

                Employee keyI = elementI.getKey();
                Employee keyJ = elementJ.getKey();

                if (valueI.compareTo(valueJ) > 0) {
                    mas.set(i, elementJ);
                    mas.set(j, elementI);
                } else if (valueI.compareTo(valueJ) == 0) {
                    if (keyI.compareTo(keyJ) > 0) {
                        mas.set(i, elementJ);
                        mas.set(j, elementI);
                    }
                }
            }
        }
        List<Employee> newSortedList = new ArrayList<>();
        for (var el : mas) {
            newSortedList.add(el.getKey());
        }

        return newSortedList;
    }

}


