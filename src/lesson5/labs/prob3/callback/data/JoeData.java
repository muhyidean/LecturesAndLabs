package lesson5.labs.prob3.callback.data;

import java.util.HashMap;

public class JoeData implements Data {
	static HashMap<String, String> grades = new HashMap<>();
	static {
		grades.put("Chemistry", "C");
		grades.put("Math", "C+");
		grades.put("Language", "C-");
	}
	static HashMap<String, String> remarks = new HashMap<>();
	static {
		remarks.put("Ms Lane", "Joe was my worst student this year.");
		remarks.put("Mr Thompson", "Joe tries very hard.");
		remarks.put("Ms Stevens", "Joe does not seem to have a first language.");
	}
	
	public HashMap<String, String> getGrades() {
		return grades;
	}
	
	public HashMap<String, String> getTeacherRemarks() {
		return remarks;
	}
}
