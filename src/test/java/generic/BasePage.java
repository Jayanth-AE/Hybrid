package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage 
{
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickableElement(int time, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e)
		{
			Reporter.log("failed to click the element", true);
			Assert.fail();
		}
	}
	
	public void visibleElement(int time, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e)
		{
			Reporter.log("element not visible", true); 
			Assert.fail();
		}
	}
	
	public void presenceOfElement(int time, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e)
		{
			Reporter.log("element is not present", true);
			Assert.fail();
		}
	}
	
	public void verifyTitle(int time,String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		try
		{
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			Reporter.log("title not displayed", true);
			Assert.fail();
		}
	}
}