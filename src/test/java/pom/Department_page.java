package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class Department_page extends BasePage
{
	@FindBy(xpath = "//button[contains(.,'Add Department')]")
	private WebElement AddDept;
	
	@FindBy(xpath = "//input[@id='field-1']")
	private WebElement name;
	
	@FindBy(xpath = "//textarea[@id='field-ta']")
	private WebElement description;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement search;
	
	@FindBy(xpath = "//td[.='Gynacology']")
	private WebElement dep;
	
	@FindBy(xpath = "//img[@src='assets/images/logo.png']")
	private WebElement dashboard;
	
	public Department_page (WebDriver driver)
	{
		super(driver);
	}
	
	public void clickon_Add_Department()
	{
		AddDept.click();
	}
	
	public void enter_Dept_name(String D_name)
	{
		clickableElement(8, name);
		name.sendKeys(D_name);
	}
	
	public void enter_Description(String Desp)
	{
		description.sendKeys(Desp);
	}
	
	public void clickon_Submit()
	{
		submit.click();
	}
	
	public void search_Dept(String Dname)
	{
		search.sendKeys(Dname);
	}
	
	public void verify_dep()
	{
		presenceOfElement(5, "//td[.='Gynacology']");
	}
	
	public void clickon_Dashboard_Icon()
	{
		dashboard.click();
	}
}
