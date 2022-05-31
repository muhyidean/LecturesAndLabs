package inclassdemos.lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mappings {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dean", "Zaineh", "Yasmeen");
        List<Integer> nums = countWords2(names);

        System.out.println(nums);
    }

    public static Integer countWords(String s){
        return  s.length();
    }


    public static List<Integer> countWords2(List<String> words){
        return
                words.stream()
                        .map(s -> countWords(s))
                        .collect(Collectors.toList());
    }

    public static int[] countWords3(List<String> words){
        return
                words.stream()
                        .mapToInt(s -> countWords(s))
                        .toArray();
    }

    public static Integer[] countWords4(List<String> words){
        return
                words.stream()
                        .map(s -> s.length())
                        .toArray(Integer[]::new);
    }


}
