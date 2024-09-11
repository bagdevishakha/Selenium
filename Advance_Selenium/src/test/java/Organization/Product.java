package Organization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Object_Repository.CreateProductPage;
import Object_Repository.HomePage;
import Object_Repository.VtigerLoginPage;

public class Product {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//step1:to get java object representing physical file path

		//	FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties.txt");

		//step2:create object of properties class to load all keys 

		//Properties pro = new Properties();
		//	 pro.load(fis);

		//step3: get the values of all properties

		//	String URL = pro.getProperty("url");
		//	String USERNAME = pro.getProperty("username");
		//	String PASS = pro.getProperty("password");

		File_Utility flib = new File_Utility();
		Java_Utitlity jlib = new Java_Utitlity();
		Excel_Utility elib = new Excel_Utility();

		String URL =flib.getPropertiesData("url");
		String USERNAME =flib.getPropertiesData("username");
		String PASS =flib.getPropertiesData("password");

		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// driver.findElement(By.name("user_password")).sendKeys(PASS);
		// driver.findElement(By.id("submitButton")).click();

		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME,PASS);

		// driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		CreateProductPage crpg = new CreateProductPage(driver);
		crpg.clickOnPlusSign();
		// driver.findElement(By.xpath("//img [@alt = 'Create Product...']")).click();


		int ranNum = jlib.getRandomNum();

		//read data from excel
		//  FileInputStream fes = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
		//keep excel in read mode 
		// Workbook book = WorkbookFactory.create(fes);

		// Sheet sheet =book.getSheet("sheet2");

		// Row row = sheet.getRow(0);

		// Cell cel = row.getCell(0);

		// String product = cel.getStringCellValue();


		String product =  elib.getExcelData("sheet2", 0, 0)+ranNum;
		System.out.println(product);




		crpg.enterProductName(product);
		crpg.clickOnSaveButton();
		//driver.findElement(By.name("productname")).sendKeys(product);
		//driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		//signout
		// driver.findElement(By.xpath("//img[@src= 'themes/softed/images/user.PNG']")).click();
		Thread.sleep(4000);
		home.logOutFromApp();
		//driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
