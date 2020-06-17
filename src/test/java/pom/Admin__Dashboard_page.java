package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class Admin__Dashboard_page extends BasePage
{
	@FindBy(xpath = "(//li[@class='root-level'])[1]")
	private WebElement Department;
	
	@FindBy(xpath = "//span[.='Doctor']")
	private WebElement doc;
	
	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement logout;
	
	public Admin__Dashboard_page(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickon_Department()
	{
		clickableElement(5, Department);
		Department.click();
	}
	
	public void clickon_Doctor()
	{
		doc.click();
	}
	
	public void clickon_Logout()
	{
		logout.click();
	}
}