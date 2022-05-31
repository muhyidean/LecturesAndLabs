package inclassdemos.lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams4 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> nlist = Arrays.asList("Moe", "Adam", "Ibrahim", "Julliane", "Mike", "Moe", "John", "Mark");
		
		Arrays.asList("a1","a2","a3")
	    .stream()
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		System.out.println("-----------------------");
		
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		System.out.println("-----------------------");
		
		IntStream.range(1, 4)
	    .forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		Integer[] arrOfInt= {1, 2, 3, 4};
		Stream.of(arrOfInt)
				.map(n -> 2 * n + 1)
				.forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);  // 5.0
		
		System.out.println("-----------------------");
		
		Stream<String> song = Stream.of("gently", "down", "the", "stream");
		song
		.filter(x -> x.startsWith("g"))
		.map(x -> x + "WWW")
		.forEach(System.out::println);
		
		System.out.println("-----------------------");
	
		nlist.stream() // This is taken from a List 
		.filter(x -> x.startsWith("M"))
		.map(x -> x + "WWW")
		.forEach(System.out::println);
		//.collect(Collectors.toList());
		
		nlist.stream()
		.forEach(System.out::println);
		
		
		int[] arrOfInt1= {1, 3, 5, 7};
		//Stream<int[]> strOfInt= Stream.of(arrOfInt);  NOT ALLOWED!
		
		System.out.println("-------------------------------");
		Stream<String> names1 = Stream.of("Zaineh", "Yasmeen", "Nee");
		Stream<String> names2 = Stream.of("Ngo","Pham","Vo");
		Stream<String> allnames = Stream.concat(names1, names2);
		
		allnames
		.filter(x -> x.startsWith("N"))
		.map(x -> x + "ADDITION")
		.forEach(System.out::println);
		
		// THIS WILL MAKE A RUNTIME ERROR!
//		allnames
//		.forEach(System.out::println);

		System.out.println(allnames.collect(Collectors.toList()));
	}

}
