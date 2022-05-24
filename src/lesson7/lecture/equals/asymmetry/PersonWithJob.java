package lesson7.lecture.equals.asymmetry;

class PersonWithJob extends Person {
	private int salary;

	public PersonWithJob(String n, int s) {
		super(n);
		salary = s;
	}

	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null) {
			return false;
		}
		if (!(aPerson instanceof PersonWithJob)) { 
			return false;
		}
		PersonWithJob p = (PersonWithJob) aPerson;
		boolean isEqual = getName().equals(p.getName()) 
				&& this.salary == p.salary;
		return isEqual;
	}

}
