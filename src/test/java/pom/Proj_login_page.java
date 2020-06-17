package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class Proj_login_page extends BasePage 
{
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pass;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-login']")
	private WebElement login;
	
	public Proj_login_page(WebDriver driver)
	{
		super(driver);
	}
	
	public void enter_Username(String username)
	{
		clickableElement(5, email);
		email.sendKeys(username);
	}
	
	public void enter_Password(String password)
	{
		pass.sendKeys(password);
	}
	
	public void clickon_Login()
	{
		login.click();
	}

}
