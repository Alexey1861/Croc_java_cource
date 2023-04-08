package ru.croc.cource;

import org.junit.Assert;
import org.junit.Test;
import ru.croc.course.Exercise;
import ru.croc.course.support.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExercise {
    @Test
    public void testSeparateByManagers() {
        Exercise exercise = new Exercise();

        Employee manager1 = new Employee(1, "Aleksey", null);
        Employee manager2 = new Employee(2, "Maxim", null);

        List<Employee> employeeList = new ArrayList<>();

        var worker1 = new Employee(3, "Andrey", manager1);
        var worker2 = new Employee(4, "Dmitriy", manager1);
        var worker3 = new Employee(5, "Valiliy", manager2);

        employeeList.add(worker1);
        employeeList.add(worker2);
        employeeList.add(worker3);

        Map<Employee, List<Employee>> resultDict = new HashMap<>();

        List<Employee> manager1List = new ArrayList<>();
        manager1List.add(worker1);
        manager1List.add(worker2);

        resultDict.put(manager1, manager1List);

        List<Employee> manager2List = new ArrayList<>();
        manager2List.add(worker3);

        resultDict.put(manager2, manager2List);

        Assert.assertEquals(exercise.separateByManagers(employeeList), resultDict);
    }

    @Test
    public void testSortManagers() {
        Exercise exercise = new Exercise();

        Employee manager1 = new Employee(1, "Aleksey", null);
        Employee manager2 = new Employee(2, "Maxim", null);

        List<Employee> employeeList = new ArrayList<>();

        var worker1 = new Employee(3, "Andrey", manager1);
        var worker2 = new Employee(4, "Dmitriy", manager1);
        var worker3 = new Employee(5, "Valiliy", manager2);

        employeeList.add(worker1);
        employeeList.add(worker2);
        employeeList.add(worker3);

        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(manager2);
        expectedResult.add(manager1);

        List<Employee> actualResult = exercise.getSortedManagersList(exercise.separateByManagers(employeeList));


        Assert.assertEquals(actualResult, expectedResult);
    }
}
