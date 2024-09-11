package Organization;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Object_Repository.CreateOrganizationPage;
import Object_Repository.HomePage;
import Object_Repository.VtigerLoginPage;

public class Organization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		File_Utility flib = new File_Utility();
		Java_Utitlity jlib = new Java_Utitlity();
		Excel_Utility elib = new Excel_Utility();

		//to get java representation object of physical file 
		//	FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties.txt");

		//create object of properties class to load all keys

		//Properties pro = new Properties();
		//	pro.load(fis);

		// get the value of all keys 

		// String URL = pro.getProperty("url");
		// String USERNAME = pro.getProperty("username");
		// String PASS = pro.getProperty("password");



		String URL = flib.getPropertiesData("url");
		String USERNAME = flib.getPropertiesData("username");
		String PASS = flib.getPropertiesData("password");


		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASS);
		//driver.findElement(By.id("submitButton")).click();

		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME,PASS);

		//driver.findElement(By.linkText("Organizations")).click();
		HomePage home = new HomePage(driver);
		home.clickOrganizationLink();
		//driver.findElement(By.xpath("//a[text() = 'Organizations']")).click();
		//	driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();



		//read data from excel 
		// FileInputStream fes = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
		//keep excel in read mode 
		// Workbook book = WorkbookFactory.create(fes);

		//  Sheet sheet =book.getSheet("sheet1");

		//  Row row = sheet.getRow(0);

		// Cell cel = row.getCell(0);

		//  String orgN = cel.getStringCellValue();
		// System.out.println(orgN);


		String orgN = elib.getExcelData("sheet1", 0, 0)+ranNum;

		//fetching ph no 

		String ph = elib.getExcelData("sheet1", 1, 0);
		//Row row1 = sheet.getRow(1);

		//Cell cel1 = row1.getCell(0);

		String email = elib.getExcelData("sheet1", 2, 0);



		//  DataFormatter format = new DataFormatter();
		//  String ph = format.formatCellValue(cel1);

		//  Row row2 = sheet.getRow(2);

		// Cell cel2 = row2.getCell(0);

		//  String email = cel2.getStringCellValue();
		//   System.out.println(email);

		orgPage.enterOrgName(orgN);
		orgPage.enterOrgPhoneNum(ph);
		orgPage.enterOrgEmail(email);
		//orgPage.clickOnSaveButton();
		//driver.findElement(By.name("accountname")).sendKeys(orgN);
		//driver.findElement(By.id("phone")).sendKeys(ph);
		//driver.findElement(By.id("email1")).sendKeys(email);
		//driver.findElement(By.xpath("//input[@title = \"Save [Alt+S]\"]")).click();


		//signout
		// driver.findElement(By.xpath("//img[@src= 'themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);

		//	driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);
		home.logOutFromApp();

		driver.close();

	}

}
