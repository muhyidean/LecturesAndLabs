package lesson9.lecture.flatmapstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Joe", "Harry");
		List<String> list2 = Arrays.asList("Bob", "Tom");
		
		List<Stream<String>> list = new ArrayList<>();
		list.add(stringStreamMaker(list1));
		list.add(stringStreamMaker(list2));
		//list.stream is a stream of streams of strings
		//flatMap for this stream, applied to identity map
		//yields a stream of all strings that occur in any of the streams
		System.out.println(list.stream().flatMap((Stream<String> z) -> z)
				.collect(Collectors.toList()));
		
        //Can create this stream of streams of strings using map instead.
		//Mapper: List<String> list -> Stream<String>
		//Output of map on the newList is a stream of streams of Strings
		//Then flatMap is applied to this output to yield a stream of strings
		List<List<String>> newList = new ArrayList<>();
		newList.add(list1);
		newList.add(list2);
		System.out.println(newList.stream().map(lst -> stringStreamMaker(lst))
		    .flatMap(z -> z)
		    .collect(Collectors.toList()));
	}
	
	static Stream<String> stringStreamMaker(List<String> list) {
		return list.stream();
	}

}
