package lesson7.lecture.equals.asymmetry;

class Person {
	private String name;

	public Person(String n) {
		name = n;
	}
	public String getName() {
			return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
}
