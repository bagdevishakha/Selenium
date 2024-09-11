package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertingDataTo_File {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
         FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties.txt");
	
        Properties pro = new Properties();
        pro.setProperty("url", "https://www.saucedemo.com/v1/");
        pro.setProperty("username", "standard_user");
        pro.setProperty("password", "secret_sauce");
        
        FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData.properties.txt");
        pro.store(fos, "Common Data");
        
        
	
	}
	

}
