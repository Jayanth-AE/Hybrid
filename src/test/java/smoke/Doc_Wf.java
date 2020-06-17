package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Data_provider;
import generic.Generic_test;
import pom.Doc_Dashboard_page;

public class Doc_Wf extends Generic_test
{
	@Test(dataProvider = "authenticate")
	public void Doc (String emailId, String pwd)
	{
		Doc_Dashboard_page dd= new Doc_Dashboard_page(driver);
		dd.Enter_email(emailId);
		dd.Enter_password(pwd);
		dd.Click_on_Submit();
	}
	
	@DataProvider(name="authenticate")
	public Object[][] getData()
	{
		Object[][] testdata = Data_provider.getData("Sheet3");
		return testdata;
	}
}