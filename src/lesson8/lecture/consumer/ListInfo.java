package lesson8.lecture.consumer;

import java.util.*;
import java.util.function.Consumer;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	
	class MyConsumer implements Consumer<String> {
		public void accept(String t) {
			strList.add(t);
		}
	}
	
	
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		//use java8 foreach to copy all list elements into strList
		MyConsumer consumer = new MyConsumer();
		list.forEach(consumer);
		System.out.println(strList);
	}
	


}
