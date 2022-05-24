package lesson8.lecture.consumer;

import java.util.function.Consumer;

/* Can implement a Consumer as an independent class, but then it is not a closure */
public class MyConsumer implements Consumer<String> {
	private MyStringList list;
	public MyConsumer(MyStringList list) {
		this.list = list;
	}
	@Override
	public void accept(String item) {
		list.add(item);	
	}
}
