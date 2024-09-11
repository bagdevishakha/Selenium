package Product;

import java.io.FileInputStream;
import java.io.IOException;
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

public class Delete_Product {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		File_Utility flib = new File_Utility();
		Java_Utitlity jlib = new Java_Utitlity();
		Excel_Utility elib = new Excel_Utility();

		//to get java representation object of physical file 
		//FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties.txt");

		//create object of properties class to load all keys

		//Properties pro = new Properties();
		//	pro.load(fis);

		// get the value of all keys 

		//String URL = pro.getProperty("url");
		//	String USERNAME = pro.getProperty("username");
		//	String PASS = pro.getProperty("password");


		String URL = flib.getPropertiesData("url");
		String USERNAME = flib.getPropertiesData("username");
		String PASS = flib.getPropertiesData("password");

		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// driver.findElement(By.name("user_password")).sendKeys(PASS);
		//driver.findElement(By.id("submitButton")).click();

		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME,PASS);

		//driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickProductLink();

		CreateProductPage crpg = new CreateProductPage(driver);
		crpg.clickOnPlusSign();
		//driver.findElement(By.xpath("//img [@alt = 'Create Product...']")).click();

		//to avoid duplicate


		int ranNum = jlib.getRandomNum();

		//read data from excel
		// FileInputStream fes = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
		//keep excel in read mode 
		//  Workbook book = WorkbookFactory.create(fes);

		//  Sheet sheet =book.getSheet("sheet2");

		//  Row row = sheet.getRow(0);

		// Cell cel = row.getCell(0);

		//  String product = cel.getStringCellValue();

		String product = elib.getExcelData("sheet2", 0, 0)+ranNum;
		System.out.println(product);


		crpg.enterProductName(product);
		crpg.clickOnSaveButton();
		crpg.clickOnProducts();
		// driver.findElement(By.name("productname")).sendKeys(product);
		// driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		//driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class ='lvt small']//a[text()='"+product+"']/../preceding-sibling::td//input[@type = 'checkbox']")).click();	

		Thread.sleep(4000);
		//Click on delete button
		crpg.clickOnDeleteProducts();
		//  driver.findElement(By.xpath("//input[@value='Delete']")).click();

		//handling alert
		driver.switchTo().alert().accept();

		//sign Out

		// driver.findElement(By.xpath("//img[@src= 'themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		home.logOutFromApp();
		//driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
