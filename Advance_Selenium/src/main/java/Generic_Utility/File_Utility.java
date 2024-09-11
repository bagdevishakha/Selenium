package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	public String getPropertiesData(String key) throws Throwable
	{
FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties.txt");
		
		// step 2: create object of properties class to load all keys
		
		Properties pro = new Properties();
		pro.load(fis);
		
		//step3:read value using getproperty
		String value= pro.getProperty(key);
		return value;
	}
	

}


