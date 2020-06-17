package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class Doc_Dashboard_page extends BasePage
{
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	public Doc_Dashboard_page(WebDriver driver)
	{
		super(driver);
	}
	
	public void Enter_email(String emailId)
	{
		email.sendKeys(emailId);
	}
	
	public void Enter_password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void Click_on_Submit()
	{
		submit.click();
	}
}