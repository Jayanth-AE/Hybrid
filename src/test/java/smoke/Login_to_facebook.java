package smoke;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Data_provider;
import generic.Excel;
import generic.Generic_test;
import pom.Facebook_login_page;

public class Login_to_facebook extends Generic_test
{
	@Test(groups="impact",dataProvider = "authenticate")
	public void login(String username, String pass)
	{
		test=reports.createTest("Login to Facebook", "user enters valid credentials inorder to login");
		
		test.info("login to facebook test is started");
		Facebook_login_page f=new Facebook_login_page(driver);
		f.enterEmail(username);
		test.pass("Successfully entered username");
		f.enterPassword(pass);
		test.pass("Successfully entered password");
		f.clickOnLogin();
		test.pass("Clicked on Login button");
		f.verifyTitle(10, "Facebook");
		Assert.assertEquals(driver.getTitle(), Excel.readData("Sheet1", 0, 0));
		test.pass("title verified successfully");
		test.info("test ended");
	}
	
	@DataProvider(name="authenticate")
	public Object[][] data()
	{
		Object[][] x = Data_provider.getData("testdata");
		
		return x;
	}
}