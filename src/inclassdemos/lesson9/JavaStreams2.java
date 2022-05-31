
package inclassdemos.lesson9;

import java.lang.String;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class JavaStreams2 {
	public static void main(String[] args) throws IOException {
		

		// 1. max
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		Optional<String> largest = people.stream()
				.sorted()
				.max(String::compareToIgnoreCase);
		
		if (largest.isPresent())  System.out.println("Largest: " + largest.get());
		
		// 2. FindFirst
		List<String> otherpeople = Arrays.asList("Neil", "Adam", "Nader", "Sarika", "Amanda", "Hans", "Shivika", "Sarah");
		Optional<String> startsWithN = otherpeople.stream()
				.filter(s -> s.startsWith("N"))
				.findAny();
		if (startsWithN.isPresent())  System.out.println("First with N: " + startsWithN.get());
		
		//3. 
		pickName(people,"Q");
	
	}
	
	public static void pickName (final List<String> names, final String startingLetter){
		Optional<String> foundName= names.stream()
				.filter(name ->name.startsWith(startingLetter))
				.findFirst();
		System.out.println(String.format("A name starting with %s: %s",startingLetter,foundName.orElse("No name found")));
		}
	
	
	
	
	
}