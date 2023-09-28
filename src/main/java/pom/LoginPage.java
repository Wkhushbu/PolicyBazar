package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage 
{
	//variables
	@FindBy(className ="sign-in") private WebElement signInbutton;
	@FindBy(xpath = "(//input[@id='central-login-module-sign-mobile'])[2]") private WebElement mobileNumber;
	@FindBy(xpath= "(//a[@id='central-loggin-with-pwd'])[2]") private WebElement signinwithpassword;
	@FindBy (id = "central-login-password") private WebElement Enterpassword;
	@FindBy (xpath= "//span[text()='Sign in']") private WebElement Signin;
	@FindBy (xpath = "//div[@class='nav-arrow']") private WebElement Myaccount;
	@FindBy (xpath = "//span[text()=' My profile ']") private WebElement Myprofile;
	
	//constructor
	public LoginPage(WebDriver driver) 
  {
	  PageFactory.initElements(driver, this);
  }
	//methods
	public void clickonSigninButton()
	{
		Reporter.log("Clicking on Homepage sign-in button", true);
		signInbutton.click();
	}
	public void EnterMobileNumber()
	{
		Reporter.log("Entering Mobile number", true);
		mobileNumber.sendKeys("8109164663");
	}
	public void ClickonSigninwithPassword()
	{
		Reporter.log("Clicking on sign-in with password", true);
		signinwithpassword.click();
	}
	public void password()
	{
		Reporter.log("Entering password", true);
		Enterpassword.sendKeys("Bruno.1234");
	}
	public void signinfinal()
	{
		Reporter.log("Clicking on Sign-in button", true);
		Signin.click();
	}
	public void account()
	{
		Reporter.log("Clicking on my account", true);
		Myaccount.click();
	}
	public void profile()
	{
		Reporter.log("Clicking on my profile", true);
		Myprofile.click();
	}
}
