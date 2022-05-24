package lesson8.lecture.lambda_param;
import java.util.function.*;
public class Main {
	int y = 7;
	
	Function<Integer, Integer> f = x -> myMethod(x,y);
	
	public int myMethod(int u, int v) {
		return u + v;
	}
	
	
	
	//there is no method reference for f, but we can do this
	Function<Integer, Integer> g = this::myMethod2;
	public static void main(String[] args) {
		Main m = new Main();
		m.process();
	}
	
	public void process() {
		System.out.println(f.apply(3));
		System.out.println(g.apply(3));
		 
	}
	
	
	
	public int myMethod2(int u) {
		return myMethod(u, u);
	}

}
