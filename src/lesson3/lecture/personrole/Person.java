package lesson3.lecture.personrole;
import java.util.*;
public class Person {
	private List<PersonRole> roles = new ArrayList<>();
	public Person() {
		//must have at least one role; use Staff by default
		addRole(Staff.INSTANCE);
	}
	public void addRole(PersonRole newRole) {
		if(newRole != null && !roles.contains(newRole)) {
			roles.add(newRole);
		}
	}
	public void changeRole(PersonRole oldRole, PersonRole newRole) {
		if(oldRole != null && newRole !=null && roles.contains(oldRole)
				&& !roles.contains(newRole)) {
			roles.remove(oldRole);
			roles.add(newRole);
		}
	}
	
	@Override
	public String toString() {
		return roles.toString();
	}
}
