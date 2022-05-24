package lesson3.lecture.personrole;

public class Student extends PersonRole {
	public static final Student INSTANCE = new Student();
	
	/* make Student a singleton */
	private Student() {}
	
	@Override
	public String toString() {
		return "Student Role";
	}
}
