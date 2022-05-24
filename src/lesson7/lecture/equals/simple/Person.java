package lesson7.lecture.equals.simple;

class Person {
	private String name;

	public Person(String n) {
		name = n;
	}
	public String getName() {
			return name;
	}
	@Override   //Cannot change type of argument to Person
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
}
