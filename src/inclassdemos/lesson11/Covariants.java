package inclassdemos.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Covariants {

    public static void main(String[] args) {


        Employee emp1 = new Employee("John", 80000);
        Manager emp2 = new Manager("Le",120000,50000);

        Employee [] employees = {emp1, emp2};


        List<Integer> ints = Arrays.asList(5, 6); // source
        List<Object> objs = Arrays.asList(2, 3.14, "four",6); // destination


        Collections.copy(objs, ints);
        System.out.println(objs);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        List<Manager> managersList = new ArrayList<>();
//        List<String> names = new ArrayList<>();
//
//
        List<? extends Employee> newEmps =  managersList;
//
//        GenericEmpList<Employee> emps = new GenericEmpList<>(managersList);

    }
}
