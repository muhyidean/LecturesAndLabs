package lesson9.lecture.iterate;
import java.math.BigInteger;
import java.util.stream.*;
public class Examples {

	public static void main(String[] args) {
		Stream<Integer> stream1 =
				Stream.iterate(1, n -> n + 1);
		Stream<BigInteger> stream2 = 
			Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
		
		stream1.limit(5).collect(Collectors.toList()).forEach(System.out::print);
		System.out.println("\n");
		stream2.limit(5).collect(Collectors.toList()).forEach(System.out::print);
	}

}
