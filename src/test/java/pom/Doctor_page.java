package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import generic.BasePage;

public class Doctor_page extends BasePage
{
	@FindBy(xpath = "//button[contains(.,'Add Doctor')]")
	private WebElement addDoc;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement ph;
	
	@FindBy(xpath = "//select[@name='department_id']")
	private WebElement dep;
	
	@FindBy(xpath = "//input[@accept='image/*']")
	private WebElement img;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement search;
	
	@FindBy(xpath = "//td[.='Shylesh']")
	private WebElement doc;
	
	public Doctor_page(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickon_AddDoctor()
	{
		addDoc.click();
	}
	
	public void enter_DocName(String docname)
	{
		clickableElement(8, name);
		name.sendKeys(docname);
	}
	
	public void enter_Email(String e_mail)
	
	{
		email.sendKeys(e_mail);
	}
	
	public void enter_Password(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void enter_Phone_no(String phone)
	{
		ph.sendKeys(phone);
	}
	
	public void select_Department(String D_name)
	{
		Select sc=new Select(dep);
		sc.selectByVisibleText(D_name);
	}
	
	public void upload_Profile_photo(String path)
	{
		img.sendKeys(path);
	}
	
	public void clickon_Submit()
	{
		clickableElement(8, submit);
		submit.click();
	}
	
	public void search_Doc_name(String docname)
	{
		clickableElement(10, search);
		search.sendKeys(docname);
	}
	
	public void verify_doc()
	{
		presenceOfElement(8, "//td[.='Shylesh']");
	}
}