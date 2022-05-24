package lesson7.lecture.equals.sameclass.theproblem;

class Person {
	private String name;

	Person(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson.getClass() != this.getClass()) 
			return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;

	}
}
