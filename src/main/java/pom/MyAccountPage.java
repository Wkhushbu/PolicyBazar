package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityClass.*;

public class MyAccountPage 
{
	//variables
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement UN;
	@FindBy(xpath= "//div[@title='Logout']") private WebElement Lout;
	
	//constructor
	public MyAccountPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
	//methods
	public String getActualUserName()
	{
		Reporter.log("getting Actual Username", true);
		Utility.waitt(1000);
		String ActualUN = UN.getText();
		return ActualUN;
	}
	public void logout()
	{
		Reporter.log("logging out", true);
		Lout.click();
	} 
}
