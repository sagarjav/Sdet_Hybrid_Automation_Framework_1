package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_001_Verify_successful_login_with_valid_credentials extends BaseClass {
	

	
	@Test
	public void Verify_successful_login_with_valid_credentials() throws InterruptedException
	{
		logger.info("Verify Successfull Login is start.....");
		try
		{
		LoginPage LP=new LoginPage(driver);
		
		LP.clickOnbtnoginRegister();
		Thread.sleep(3000);
		LP.setLoginEmail("technicaltipsinhindi143@gmail.com");
		Thread.sleep(3000);
		LP.clickOnbtncontinue();
		logger.info("click on continue button...");
		Thread.sleep(3000);
		LP.setloginPassword1("Groww@123$%");
		Thread.sleep(3000);
		LP.clickSubmit();
		Thread.sleep(5000);
		logger.info("click on submit button...");
		LP.otpinput88parent("235874");
		
			/*	if(true==false)
				{
					Assert.assertTrue(true);
					
				}
				else
				{
					logger.error("Test Failed..");
					logger.debug("Debug logs..");
					Assert.assertTrue(false);
				} */
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("Verify Successfull Login is end.....");
	}
	
	

}
