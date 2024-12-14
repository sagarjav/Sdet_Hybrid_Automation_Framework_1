package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Compund_Interest_Calculator_Page;
import pageObjects.GrowwCalculatorsPage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC_003_Verify_Compund_Interest_CalculatorDDT extends BaseClass 
{
	@Test(dataProvider="CompoundIntCal",dataProviderClass=DataProviders.class ) //Getting data from different class
	public void Verify_Compund_Interest_Calculator(String PA,String ROI, String TP,String ER ) throws InterruptedException 
	{
		logger.info("compound Interest Calculator Test is Started.....");
		LoginPage LG=new LoginPage(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(LG.getFooterCalculators()));
		Thread.sleep(3000);
		action.scrollToElement(LG.getFooterCalculators()).perform();
		Thread.sleep(3000);
		LG.clickOnCalculators();
		
		//GrowwCalculatorsPage 
	    logger.info("Calculator Test is Started.....");
		GrowwCalculatorsPage GC=new GrowwCalculatorsPage(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(GC.getCompundInterest()));
		Thread.sleep(3000);
		action.scrollToElement(GC.getCompundInterest()).perform();
		Thread.sleep(3000);
		GC.clickOnCompundInterest();
		Thread.sleep(3000);
		//Assert.assertEquals(driver.getTitle(), "Compound Interest Calculator Online India");
		
		
		//Compund_Interest_Calculator_Page
		Compund_Interest_Calculator_Page CIC=new Compund_Interest_Calculator_Page(driver);
		wait.until(ExpectedConditions.visibilityOf(CIC.getPrincipalAmount()));
		Thread.sleep(3000);
		CIC.getPrincipalAmount().clear();
	
	
		
		//CIC.setPrincipalAmount("100000");
		Thread.sleep(3000);
		CIC.getPrincipalAmount().sendKeys(PA);
		
		wait.until(ExpectedConditions.visibilityOf(CIC.getRateofInterest()));
		Thread.sleep(3000);
	    CIC.getRateofInterest().clear();
		Thread.sleep(3000);
		CIC.setRateofInterest(ROI);
		
		
		wait.until(ExpectedConditions.visibilityOf(CIC.getTimePeriod()));
		Thread.sleep(3000);
	    CIC.getTimePeriod().clear();
		Thread.sleep(3000);
		CIC.setTimePeriod(TP);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(CIC.getTotalAmount()));
		Thread.sleep(3000);
		
		//verify test 
		
		int actualTotalAmount=CIC.TotalAmount();
		int expectedTotalAmount=Integer.parseInt(ER.replace(",", ""));
		
		
		Assert.assertTrue(actualTotalAmount==expectedTotalAmount, "Test is Failed");
		
	}

}
