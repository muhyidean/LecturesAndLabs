package inclassdemos.lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreams{
	
	static List <String> nlist = Arrays.asList("Moe", "Adam", "Ibrahim", "Julliane", "Mike", "Moe", "John", "Mark");
	static int[] narrs = {20,45,50,30,40,60,70,};
	static List<Integer> ndbl =  Arrays.asList(20,45,50,30,4,67,10,34,78);
	
	public static List <String> namesWithM(List <String> list){
		return list
				.stream()
				.filter(x -> x.startsWith("M"))
				.collect(Collectors.toList());
	}

public static OptionalDouble avgFirstFive(int [] arr){
		return 
				Arrays.stream(arr)
				.filter(x -> x >50)
				.limit(5)
				.average();
	}

public static OptionalDouble avgFirstFiveD(List <Integer> il){
	return 
			il.parallelStream()
			.filter(x -> x >50)
			.limit(5)
			.mapToInt((x) -> x)
			.average();
}
	
	public static void main(String [] args){
		System.out.println("Sequential" + avgFirstFive(narrs));
		System.out.print("Parallel" + avgFirstFiveD(ndbl));
	}
}