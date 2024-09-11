package Campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CampainWithProduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 
		//step1:to get java object representing physical file path
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties.txt");
		
		//step2:create object of properties class to load all keys 
		
		Properties pro = new Properties();
		pro.load(fis);
		
		//step3: get the values of all properties
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASS = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASS);
	    driver.findElement(By.id("submitButton")).click();
	    
	    //create campaign
	    WebElement link = driver.findElement(By.linkText("More"));
		   Actions act = new Actions(driver);
		   act.moveToElement(link).click().perform();
	    
	    driver.findElement(By.linkText("Campaigns")).click();
	    driver.findElement(By.xpath("//img [@alt = 'Create Campaign...']")).click();
	    
	  //TO avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
	    
	   //read data from excel
	    FileInputStream fes = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
	    //keep excel in read mode 
	    Workbook book = WorkbookFactory.create(fes);
	    
	    Sheet sheet =book.getSheet("sheet3");
	    
	    Row row = sheet.getRow(0);
	    
	    Cell cel = row.getCell(0);
	    
	    String CampName = cel.getStringCellValue();
	    System.out.println(CampName);
	  
	    
	    
	    driver.findElement(By.name("campaignname")).sendKeys(CampName);
	    driver.findElement(By.xpath("//img[@alt = 'Select']")).click();
	    driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
	    
	    
	  //signout
	    driver.findElement(By.xpath("//img[@src= 'themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}



	}



	