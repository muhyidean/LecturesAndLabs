package inclassdemos.lesson11;

import java.util.List;

public class GenericEmpList<T extends Employee> {

    List<T> employees;

    public GenericEmpList(List<? extends T> employees) {
        this.employees = (List<T>) employees;
    }

    public void print(){
    }


}
