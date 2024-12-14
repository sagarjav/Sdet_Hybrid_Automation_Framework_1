package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compund_Interest_Calculator_Page 
{
  public Compund_Interest_Calculator_Page(WebDriver driver) 
  {
	  PageFactory.initElements(driver, this);
  }
  
	  //Locators
   @FindBy(xpath="//*[@id=\"PRINCIPAL_AMOUNT\"]")
   private WebElement PrincipalAmount;
   
   @FindBy(xpath="//div[@class='valign-wrapper'][normalize-space()='Principal amount']") 
    private WebElement txtprincipalAmount;
   
   @FindBy(xpath="//input[@id='RATE_OF_INTEREST']")
   private WebElement RateofInterest;
   
   @FindBy(xpath="//input[@id='TIME_PERIOD']")
   private WebElement TimePeriod;
   
   @FindBy(xpath="//table[@class='tb10Table cic23InfoTable']//tr[3]//td[2]")
   private WebElement TotalAmount;
   
    //Return Locators
   public WebElement gettxtprincipalAmount() {
	   return txtprincipalAmount;
   }
   
   public WebElement getPrincipalAmount() {
	   return PrincipalAmount;
   }
   
   public WebElement getRateofInterest() {
	   return RateofInterest;
   }
   
   public WebElement getTimePeriod() {
	   return TimePeriod;
   }
   
   public WebElement getTotalAmount() {
	   return TotalAmount;
   }
	  
	  //Actions
   public void setPrincipalAmount(String PA) {
	   PrincipalAmount.sendKeys(PA);
   }
   
   public void setRateofInterest(String ROI) {
	   RateofInterest.sendKeys(ROI);
   }
   
   public void setTimePeriod(String Time) {
	   TimePeriod.sendKeys(Time);
   }
   
   public int TotalAmount() {
	String  str1=TotalAmount.getText().replace(",", "").replace("₹",""); 
			return Integer.parseInt(str1); 
			
   }
   
  
  
}
