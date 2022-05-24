package lesson5.labs.prob3.callback.data;

import java.util.Properties;

public class Logins {
	private static Properties props = new Properties();
	static {
		//load usernames and passwords
		props.setProperty("Joe", "Joe");
		props.setProperty("Alice", "Alice");
	}
	public static boolean foundUserNamePwd(String name, String pwd) {
		return props.containsKey(name) && props.getProperty(name).equals(pwd);
	}
}
