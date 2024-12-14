package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_002_Verify_Logo_is_Displayed extends BaseClass
{
	@Test(groups="sanity")
	public void Verify_Logo_is_Displayed() 
	{
			LoginPage Lg=new LoginPage(driver);
			
			
			//Assert.assertTrue(Lg.isLogoDipalyed(), "Logo is Displaying: "+ Lg.isLogoDipalyed());
			logger.info("--> Logo is not dasplayed <---");
			Assert.fail();
	
	}
	

}
