package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(linkText = "Campaigns")
    private WebElement CampaignLink;
    
    @FindBy(xpath = "//img [@alt = 'Create Campaign...']")
    private WebElement CampPlusSign;
    
    @FindBy(name = "Campaignname")
    private WebElement campaignName;
    
    @FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
    private WebElement saveButton;

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getCampPlusSign() {
		return CampPlusSign;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void ClickOnCampaignLink()
	{
		CampaignLink.click();
	}

	public void ClickOnplusSign()
	{
		CampPlusSign.click();
	}
	
	public void enterCampName(String campName)
	{
		campaignName.sendKeys(campName);
	}
	
	public void ClickOnsaveButton()
	{
		saveButton.click();
	}
	
}

