package lesson10.lecture.annotation;

import lesson10.lecture.libcompanion.Employee;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BugReport {
	String assignedTo() default "[none]";
	int severity() default 0;

}


