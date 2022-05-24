package lesson7.lecture.empmanager.usecomposition;

import java.time.LocalDate;
import java.util.Date;


/** Implementation of Manager using Compostion instead of Inheritance.
 *  Now we can't use Manager in context of polymorphism, but it can
 *  support a different equals implementation.
 *  
 */
public final class Manager {
	private Employee emp;
	private int bonus;

	public Manager(String name, int salary, int year, int month, int day) {
		emp = new Employee(name,salary, year, month, day);
		bonus = 0;
	}	
	public double getSalary() {
		// use private Employee instance instead of super
		double baseSalary = emp.getSalary();
		return baseSalary + bonus;
	}
	public String getName() {
		return emp.getName();
	}
	public LocalDate getHireDay() {
		return emp.getHireDay();
	}
	public void setBonus(int b) {
		bonus = b;
	}
	
	@Override
	public boolean equals(Object ob) {
		if (ob == null) return false;
		if (ob.getClass() != getClass()) return false;
		Manager m = (Manager) ob;
		return (m.emp.equals(emp) && m.bonus == bonus);	
	}
	
	/** Override hashCode whenever you override equals */
	@Override
	public final int hashCode() {
		int result = 17;
		long bonusHashLong = Double.doubleToLongBits(bonus);
		int bonusHash = (int) (bonusHashLong ^ (bonusHashLong >>> 32));
		result = 31 * result + emp.hashCode();
		result = 31 * result + bonusHash;
		return result;
	}
	
}
