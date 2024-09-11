package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img [@alt = 'Create Product...']")
	private WebElement productPlusSign;
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;
	  
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(linkText = "Products")
	private WebElement Products;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement DeleteProducts;

	public WebElement getProductPlusSign() {
		return productPlusSign;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public WebElement getProducts() {
		return Products;
	}

	public WebElement getDeleteProducts() {
		return DeleteProducts;
	}

	public void clickOnPlusSign()
	{
		productPlusSign.click();
	}
	
	public void enterProductName(String prdName)
	{
		productNameTextField.sendKeys(prdName);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void clickOnProducts()
	{
		Products.click();
	}

	public void clickOnDeleteProducts()
	{
		DeleteProducts.click();
	}

}
