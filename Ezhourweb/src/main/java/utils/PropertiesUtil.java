package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

	public class PropertiesUtil {
	    private static Properties properties = new Properties();

	    static {
	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/users.properties");
	            properties.load(fis);
	        } catch (IOException e) {
	            System.err.println("Failed to load properties file: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    public static String get(String key) {
	        return properties.getProperty(key);
	    }

}
