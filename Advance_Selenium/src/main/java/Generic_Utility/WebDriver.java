package Generic_Utility;

public class WebDriver {
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	

}
