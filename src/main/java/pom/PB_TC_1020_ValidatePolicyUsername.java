package pom;

import java.io.IOException;
import basePackage.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilityClass.*;

public class PB_TC_1020_ValidatePolicyUsername extends Base
{
	LoginPage login;
	MyAccountPage MyAcc;
	String TCID = "PB_TC_1234";
	
	@BeforeClass
	  public void LaunchURL() throws IOException 
	  {
		LaunchBrowserusingPropertyFile();
		login = new LoginPage(driver);
		MyAcc = new MyAccountPage(driver);
	  }
	@BeforeMethod
	  public void LoginintoPolicyBazar() throws IOException, InterruptedException, EncryptedDocumentException
	  {
		Utility.waitt(1000);
		login.clickonSigninButton();
		Utility.waitt(1000);
		login.EnterMobileNumber();
		Utility.waitt(1000);
		login.ClickonSigninwithPassword();
		Utility.waitt(1000);
		login.password();
		Utility.waitt(1000);
		login.signinfinal();
		Utility.waitt(1000);
		login.account();
		Utility.waitt(1000);
		login.profile();
		Utility.waitt(1000);
		
		Set<String> allwindowID = driver.getWindowHandles(); //get window ID
		List<String> id = new ArrayList<>(allwindowID); //convert to List
		
		//switching focus to child ID
		driver.switchTo().window(id.get(1));
		Reporter.log("Switching to child page", true);
		Utility.waitt(1000);
	  }
	@Test
	public void verifyUsername() throws IOException, EncryptedDocumentException, InterruptedException
	{
		Utility.waitt(1000);
		String expUN = Utility.getdatafromproperty("ExpectedUN");
		String actualUN = MyAcc.getActualUserName();
		Assert.assertEquals(actualUN, expUN, "UN is not matching, TC is failed");
		Utility.captureScreenshot(driver, actualUN+" "+ TCID);
	}
	@AfterMethod
	public void logout()
	{
		MyAcc.logout();
	}
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
}
