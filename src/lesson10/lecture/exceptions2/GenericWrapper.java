package lesson10.lecture.exceptions2;

import java.io.File;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericWrapper {
	public List<String> getCanonicalPaths(String[] dirs)  {
		return Stream.of(dirs).map(
				//re-type the possibly buggy Function as a FunctionWithException
			path -> getCanonicalPathHelper((String p) -> new File(p).getCanonicalPath())
			        .apply(path))
			.map(Object::toString).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		String[] localDirs = {"/usr", "//usr", "/etc"};
		List<String> canonicalPaths 
			= (new GenericWrapper()).getCanonicalPaths(localDirs);
		System.out.println(canonicalPaths);
	}
	
	public static <T, R> Function<T,R> getCanonicalPathHelper(FunctionWithException<T,R> f) {
		return p -> {	
			try {
				//this code tries to execute new File(p).getCanonicalPath(), but now
				//is ready to catch a thrown Exception, which could be thrown by the
				//apply method in FunctionWithException
				return f.apply(p);
				 //if successful, return value is  p -> canonical path for p
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
