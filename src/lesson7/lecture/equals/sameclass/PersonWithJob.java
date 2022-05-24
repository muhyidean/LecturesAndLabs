package lesson7.lecture.equals.sameclass;

class PersonWithJob extends Person {
	private double salary;

	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}

	@Override
	public boolean equals(Object withJob) {
		if (withJob == null)
			return false;
		if (withJob.getClass() != this.getClass())
			return false;
		PersonWithJob p = (PersonWithJob) withJob;
		boolean isEqual = getName().equals(p.getName()) && this.salary == p.salary;
		return isEqual;
	}

}
