
package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import basePackage.Base;

import org.apache.poi.ss.usermodel.Sheet;

public class Utility extends Base
{
	//commonly used method
	//screenshot
	//scrolling
	//data reading
	//wait
	public static void waitt(int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	}
//Read data from excel
  public String getdatafromExcel(int Row, int cell) throws EncryptedDocumentException, IOException 
  {
	  FileInputStream Myfile = new FileInputStream("D:\\Software Testing\\Automation\\Excel Sheet\\Test.xlsx");
	  Reporter.log("Reading data from excel row number" + Row + "cell num is" + cell , true);
	  Sheet Mysheet = WorkbookFactory.create(Myfile).getSheet("Sheet2");
	  String value = Mysheet.getRow(Row).getCell(cell).getStringCellValue();
	  return value;
  }
  
//Read data from properties
  public static String getdatafromproperty(String key) throws IOException
  {
	  Properties prop = new Properties();
	  FileInputStream Myfile = new FileInputStream("C:\\Users\\Khushbu Wadhwani\\eclipse-workspace\\New_Selenium_Project\\NewFile.properties");
	  prop.load(Myfile);
	  String value = prop.getProperty(key);
	  Reporter.log("reading data" + key + "from propertyFile", true);
	  return value;
  }
  
 // Take screenshot
  public static void captureScreenshot(WebDriver driver, String filename) throws IOException
  {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest= new File("D:\\Software Testing\\Screenshot Selenium" + filename + ".png");
	  FileHandler.copy(src, dest);
	  Reporter.log("taking screenshot", true);
	  Reporter.log("Screenshot location is.." + dest, true);
  }
 //scrolling
  	public static void scrollintoView (WebDriver driver, WebElement element)
  	{
  		((JavascriptExecutor)driver).executeScript("arguement[0].scrollintoView(true)",element);
  		Reporter.log("scrollintoview", true);
  	}
 
}
