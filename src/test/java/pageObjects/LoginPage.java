package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='Login/Register']")
	private WebElement btnLoginRegister;
	
	@FindBy(xpath="//input[@id='login_email1']") 
	 private WebElement loginEmail1;
	
	@FindBy(xpath="//span[normalize-space()='Continue']") 
	 private WebElement btncontinue;
	
	@FindBy(xpath="//input[@id='login_password1']") 
	 private WebElement loginPassword1;
	
	@FindBy(xpath="(//div[@class='col l12 leps592LoginButton'])[1]") 
	 private WebElement submit;
	
	@FindBy(id="otpinput88parent") 
	 private WebElement otpinput88parent;
	
	@FindBy(xpath="(//img[@alt='Groww Logo'])[1]")
	private WebElement Logo;
	
	@FindBy(xpath="//a[normalize-space()='Calculators']")
	private WebElement FooterCalculators;
	
	//Return Locators WebElement
	public WebElement getFooterCalculators() {
		return FooterCalculators;
	}
	
	//Actions
	public void clickOnbtnoginRegister()
	{
		btnLoginRegister.click();
	}
	
	public void setLoginEmail(String Email)
	{
		loginEmail1.sendKeys(Email);
	}
	
	public void clickOnbtncontinue()
	{
		btncontinue.click();
	}
	
	public void setloginPassword1(String psw)
	{
		loginPassword1.sendKeys(psw);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public void otpinput88parent(String pin)
	{
		otpinput88parent.sendKeys(pin);
	}
	
	public boolean isLogoDipalyed()
	{
		return Logo.isDisplayed();
		
	}
	
	public void clickOnCalculators() {
		FooterCalculators.click();
	}
	
	
}
