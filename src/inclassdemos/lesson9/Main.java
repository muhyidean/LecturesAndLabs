package inclassdemos.lesson9;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Integer [] arr = {1,2,3,4,5};
        int [] intArr = {1,2,3,4};
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<String> names = Arrays.asList("Dean", "Zaineh", "Yasmeen");

        Stream<Integer> stream1 = list.stream();
        Stream<Integer> stream2 = Stream.of(arr);
        Stream<String> stream3 = Stream.of("Dean","Zaineh");
        Stream<Integer> stream4 = Arrays.stream(arr);
        IntStream  stream5 = IntStream.of(intArr);
        Stream<Integer> stream6 = Stream.concat(stream1,stream2);

        System.out.println();
        list.stream()
                .skip(2)
                .forEach(System.out::print);

        System.out.println();
        stream6
                .distinct()
                .forEach(System.out::print);

        System.out.println();
       Stream.iterate(1, n -> n+2)
               .skip(4)
               .limit(10)
               .forEach(s -> System.out.print(s+" "));

    }



}
