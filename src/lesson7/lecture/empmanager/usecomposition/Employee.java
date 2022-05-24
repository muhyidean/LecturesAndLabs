package lesson7.lecture.empmanager.usecomposition;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;


class Employee implements Cloneable {
	private String name;
	private int salary;
	private LocalDate hireDay;
	// constructor
	Employee(String aName, int aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		salary = aSalary;
		hireDay = LocalDate.of(aYear,  aMonth, aDay);
	}

	// instance methods
	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += Math.round(raise);
	}
	
	/** Make equals final to prevent unwanted overriding */
	@Override
	public final boolean equals(Object ob) {
		if (ob == null) return false;
		if (ob.getClass() != getClass()) return false;
		Employee e = (Employee) ob;
		return (e.name.equals(name) && e.salary==salary && e.hireDay.equals(hireDay));	
	}
	
	/** Override hashCode whenever you override equals */
	@Override
	public final int hashCode() {
		int result = 17;
		long salaryHashLong = Double.doubleToLongBits(salary);
		int salaryHash = (int) (salaryHashLong ^ (salaryHashLong >>> 32));
		result = 31 * result + name.hashCode();
		result = 31 * result + salaryHash;
		result = 31 * result + hireDay.hashCode();
		return result;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		Employee copy = (Employee)super.clone();
		//no need to clone LocalDate since it's immutable
		return copy;
	}
	
}
