package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(xpath = "//img[@src= 'themes/softed/images/user.PNG']")
	private WebElement logOutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	//getterMethod
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getLogOutImg() {
		return logOutImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	//this method is used to click 
	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	public void clickProductLink()
	{
		productLink.click();
	}
	
	public void clickMoreLink()
	{
		moreLink.click();
	}
	
	public void clickCampaignLink()
	{
		CampaignsLink.click();
	}
	//this method is used to log out
	public void logOutFromApp()
	{
		logOutImg.click();
		signOut.click();
	}
	
	
	
}
