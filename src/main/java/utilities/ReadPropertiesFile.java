package utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadPropertiesFile {

	public Properties readPropertiesFile() {
		Properties prop = new Properties();
		// loading file to the inputStream
		InputStream readFile = null;
		try {
			readFile = new FileInputStream(".\\.\\resources\\config.properties");
			prop.load(readFile);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
