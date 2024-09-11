package DDT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class DynamicXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Action act = new Action(driver);
		act.moveByOffset
		
	}

}
