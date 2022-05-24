package lesson3.lecture.personrole;

public class Faculty extends PersonRole {
    public static final Faculty INSTANCE = new Faculty();
	
	/* make Faculty a singleton */
	private Faculty() {}
	
	@Override
	public String toString() {
		return "Faculty Role";
	}
}
