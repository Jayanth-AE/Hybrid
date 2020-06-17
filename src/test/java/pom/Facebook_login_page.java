package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import generic.BasePage;

public class Facebook_login_page extends  BasePage
{
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath = "//label[@id='loginbutton']")
	private WebElement login;
	
	public Facebook_login_page(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterEmail(String username)
	{
		email.sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
}