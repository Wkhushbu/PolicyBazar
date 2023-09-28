package basePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import utilityClass.*;

public class Base 
{
  protected static WebDriver driver;
  
  public void LaunchBrowser()
  {
	  ChromeOptions opt = new ChromeOptions();
	  opt.addArguments("--disable-notifications");
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	  
	  driver = new ChromeDriver(opt);
	  driver.manage().window().maximize();
	  driver.get("https://www.policybazaar.com/");
  }
  
  public void LaunchBrowserusingPropertyFile() throws IOException 
  {
	  ChromeOptions opt = new ChromeOptions();
	  opt.addArguments("--disable-notifications");
	  System.setProperty("webdriver.chrome.driver", "D://D:\\chromedriver.exe");
	  
	  driver = new ChromeDriver(opt);
	  driver.manage().window().maximize();
	  driver.get(Utility.getdatafromproperty("URL"));
  }
  
  public void closeBrowser()
  {
	  Utility.waitt(1000);
	  Reporter.log("Closing Browser", true);
	  driver.quit();
  }
}
