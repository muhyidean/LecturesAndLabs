package lesson3.lecture.personrole;

public class Staff extends PersonRole {
public static final Staff INSTANCE = new Staff();
	
	/* make Staff a singleton */
	private Staff() {}
	
	@Override
	public String toString() {
		return "Staff Role";
	}
}
