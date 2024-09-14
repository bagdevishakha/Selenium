package Generic_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object_Repository.HomePage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {
	
	public WebDriver driver;
	@BeforeSuite
	public void BS()
	{
		System.out.println("DataBase Connection Open");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@BeforeClass
	public void BC() throws Throwable
	{
	
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getPropertiesData("Browser");

		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		   	 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		System.out.println("Browser launched");
	}
	
	@BeforeMethod
	public void BM() throws Throwable
	{
		File_Utility flib = new File_Utility();
		
		//WebDriver_Utility wlib = new WebDriver_Utility();
		//wlib.maximizeWindow(driver);
		//wlib.waitPageToLoad(driver);

      //reading data from properties file		

		String URL = flib.getPropertiesData("Url");
		String USERNAME = flib.getPropertiesData("UserName");
		String PASSWORD = flib.getPropertiesData("PassWord");

		
		driver.get(URL);
		//using business logics
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login To Application");
	}
	
	@AfterMethod
	public void AM()
	{
		HomePage home = new HomePage(driver);
		 home.logOutFromApp();
		System.out.println("LOgout from Application");
	}
	
	@AfterClass
	public void AC()
	{
		driver.quit();
		System.out.println("close Browser");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Close DataBase Connection");
	}
}
	


