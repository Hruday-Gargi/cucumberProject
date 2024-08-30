package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private Properties prop;
	public String getTestData(String Key) {
		try {
			FileInputStream fis=new FileInputStream("/cucumberproject/src/test/java/propertiesFile/saucelabconfig.prop");
			Properties prop=new Properties();
			prop.load(fis);
			return prop.getProperty(Key);
		}catch(IOException e) {
          e.printStackTrace();
          return null;
		}
	}
	
	public Properties getprop() {
		try {
			FileInputStream fis=new FileInputStream("./propertiesFile/saucelabconfig.prop");
			prop=new Properties();
			prop.load(fis);
			return prop;
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
