package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesMethods {

	public static void main(String[] args) throws IOException {

		// Create a .properties file
		// Create a FileInputStream object which accepts the path of the .properties
		// file
		// Create a Properties object Properties prop = new Properties()
		// prop.load(f) load this FileInputStream object

		String path = System.getProperty("user.dir") + "//config.properties";
		FileInputStream f = new FileInputStream(path);

		Properties prop = new Properties();
		prop.load(f);

		System.out.println(prop.getProperty("name"));

	}

}
