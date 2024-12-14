package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrowwCalculatorsPage 
{
	
	public GrowwCalculatorsPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Compound Interest']")
	private WebElement CompundInterestCalculator;
	
	//Return WebElement
	public WebElement getCompundInterest() {
		return CompundInterestCalculator;
	}
	
	//Actions
	public void clickOnCompundInterest() {
		CompundInterestCalculator.click();
	}
	
}
