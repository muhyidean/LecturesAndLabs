package lesson8.lecture.methodreferences.classmethod.math;

import java.util.function.BiFunction;

public class MethodRefMath {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Double> f =
				Math::pow;
				//(x,y) -> Math.pow(x, y);

		System.out.println(f.apply(2, 3).intValue());

	}
}
