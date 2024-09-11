package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
    private WebElement orgnaizationPlusSign;
	
	@FindBy(name = "accountname")
	private WebElement organizationName;
	
	@FindBy(id = "phone")
	private WebElement organizationPhoneNum;

	@FindBy(xpath = "//input[@title = \\\"Save [Alt+S]\\\"]")
	private WebElement saveButton;

	@FindBy(id = "email1")
	private WebElement organizationEmailId;

	public WebElement getOrgnaizationPlusSign() {
		return orgnaizationPlusSign;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getOrganizationPhoneNum() {
		return organizationPhoneNum;
	}

	public WebElement getOrganizationEmailId() {
		return organizationEmailId;
	}

	//business logic
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickOnPlusSign()
	{
		orgnaizationPlusSign.click();
	}
	
	public void enterOrgName(String orgName)
	{
		organizationName.sendKeys(orgName);
	}
	//This method is used to enter organization ph no
	public void enterOrgPhoneNum(String phoneNum)
	{
		organizationPhoneNum.sendKeys(phoneNum);
	}
    //this method is used to enter organization email
	
	public void enterOrgEmail(String Email)
	{
		organizationEmailId.sendKeys(Email);
	}
	//Business logic 
	
	public void orgData(String orgName, String phoneNum, String Email)
	{
		organizationName.sendKeys(orgName);
		organizationPhoneNum.sendKeys(phoneNum);
		organizationEmailId.sendKeys(Email);
	}
	 public void clickOnSaveButton()
	 {
		 saveButton.click();
	 }
}
