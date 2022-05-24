package lesson3.lecture.inheritance0.externalpackage;

import lesson3.lecture.inheritance0.Subclass;

/** Since Main lies in a different package from Superclass,
 *  this use of inheritance is not allowed. This can be fixed by
 *  doing one of two things:
 *  1. Place SuperClass and Main in same package
 *  2. Implement a print method in Subclass like this:
 *           public void print(String s) {
 *               super.print(s);
 *           }
 */
public class Main {

	public static void main(String[] args) {
		Subclass sub = new Subclass();
		//sub.print("hello");

	}

}
