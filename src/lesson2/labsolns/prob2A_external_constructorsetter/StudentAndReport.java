package lesson2.labsolns.prob2A_external_constructorsetter;

public class StudentAndReport implements IStudentAndReport {
	private Student student;
	private GradeReport report;
	public StudentAndReport(Student s, GradeReport g) {
		student = s;
		report = g;
	}
	public Student getStudent() {
		return student;
	}
	public GradeReport getGradeReport() {
		return report;
	}
	
}
