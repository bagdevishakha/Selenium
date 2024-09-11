package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration 
	
	@FindBy	(name = "user_name")
	private WebElement userTextField;
	
	@FindBy(name = "user_password")
	private WebElement passWordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButon;

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPassWordTextField() {
		return passWordTextField;
	}

	public WebElement getLoginButon() {
		return loginButon;
	}
	
	//Business Logic 
	
	/**
	 * This method is used to launch the application 
	 * @param userName
	 * @param passWord
	 * @author Vishakha
	 */
	
	public void loginToApp(String userName, String passWord)
	{
		userTextField.sendKeys(userName);
		passWordTextField.sendKeys(passWord);
		loginButon.click();
		
	}
	
	
	

}
