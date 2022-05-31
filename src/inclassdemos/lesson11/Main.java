package inclassdemos.lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {


        List<Number> genNums = new ArrayList<>();
        genNums.add(Integer.valueOf(5));
        genNums.add(5.5);


        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);



        List<? extends Number> nums = ints;
//        nums.add(3.14);

        Integer i3 = (Integer)  nums.get(0);

        Integer i = Integer.valueOf(5);

//        Object o = nums.get(0);


        List<? super Integer> intNums = genNums;

        intNums.add(5);

        Integer i2 = (Integer)  intNums.get(0);


//        Number n =  intNums.get(0);
//        System.out.println(n);









        List<String> names = new ArrayList<>();
        names.add("Le");
        names.add("Dean");

        String name = names.get(1);


        for(Object o: names){
            System.out.println((String) o);

        }
    }
}
