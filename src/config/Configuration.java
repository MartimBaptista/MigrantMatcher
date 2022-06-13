package config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

//Codigo baseado no codigo das TPs

public class Configuration {
	private static Configuration instance = new Configuration();

	public static Configuration getInstance() {
		return instance;
	}

	private Properties props = new Properties();

	private Configuration() {
		try {
			props.load(new FileInputStream("configuration.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public <E> E getInstanceOfClass(String key, E defaultValue) {
		String klassName = (String) props.get(key);
		if (klassName == null) {
			return defaultValue;
		}
		
		try {
			@SuppressWarnings("unchecked")
			Class<E> klass = (Class<E>) Class.forName(klassName);
			Constructor<E> c = klass.getConstructor();
			return c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
}
