package inclassdemos.lesson7;

import lesson7.lecture.enums.mylabel.Alignment;
import lesson7.lecture.enums2.AnEnum;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        printEnum(Alignment.CENTER);

}

public static void printEnum (Enum<?> enumSample){
    System.out.println(enumSample);
}

}
