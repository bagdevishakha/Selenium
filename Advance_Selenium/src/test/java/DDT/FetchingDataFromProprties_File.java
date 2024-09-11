package DDT;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FetchingDataFromProprties_File {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
		//driver.get("https://www.saucedemo.com/v1/");
		//driver.findElement(By.name("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.id("login-button")).click();
		
      // step1: to make connection to properties file get path from file to testfile 
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties.txt");
	
	// step2: load data from file to test script 
		
		Properties pro = new Properties();
		pro.load(fis);
		
		// step3: read value using getproperty
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		driver.close();
		
	
	
	
	}
	
	

}
