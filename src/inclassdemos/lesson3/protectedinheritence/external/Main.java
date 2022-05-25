package inclassdemos.lesson3.protectedinheritence.external;


import inclassdemos.lesson3.protectedinheritence.Employee;
import inclassdemos.lesson3.protectedinheritence.Faculty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(2,3,4));

       nums.add(5);
        System.out.println(nums);

    }
}
