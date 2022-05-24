package lesson9.lecture.summary_stat;

import java.util.*;
import java.util.stream.*;


/** Shows what happens when data is already of type Integer */
public class Example {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(2,4,6);
		Stream<Integer> stream = l.stream();
		IntSummaryStatistics summary = stream.collect(
				Collectors.summarizingInt((Integer x)-> x));
		System.out.println(summary.getAverage());

	}

}
