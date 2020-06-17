package regression;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Data_provider;
import generic.Generic_test;
import pom.Admin__Dashboard_page;
import pom.Department_page;
import pom.Doctor_page;
import pom.Proj_login_page;

public class Admin_workflow extends Generic_test
{
	@Test(dataProvider = "test data")
	public void admin(String username, String password, String Dname, String desc, String docname, String e_mail, String Docpwd, String phone, String path)
	{
		test=reports.createTest("Admin workflow", "Login as Admin create departments and users");
		test.info("Admin workflow test has started");
		Proj_login_page lp= new Proj_login_page(driver);
		lp.enter_Username(username);
		test.pass("Successfully username entered");
		lp.enter_Password(password);
		test.pass("Successfully password entered");
		lp.clickon_Login();
		test.pass("Successfully clicked on Login button");
		lp.verifyTitle(20, "Admin Dashboard");
		Assert.assertEquals(driver.getTitle(), "Admin Dashboard - HospitaManagement System");
		test.pass("title verified successfully");
		Admin__Dashboard_page ad=new Admin__Dashboard_page(driver);
		ad.clickon_Department();
		test.pass("successfully clicked on Department");
		Department_page dp=new Department_page(driver);
		dp.clickon_Add_Department();
		test.pass("clicked on Add department button");
		dp.enter_Dept_name(Dname);
		test.pass("Entered department name");
		dp.enter_Description(desc);
		test.pass("entered description");
		dp.clickon_Submit();
		test.pass("clicked on submit button");
		dp.search_Dept(Dname);
		test.pass("entered department name in search text field");
		dp.verify_dep();
		test.pass("department name is displayed in the list of department");
		dp.clickon_Dashboard_Icon();
		test.pass("clicked on Dashboard icon");
		ad.clickon_Doctor();
		test.pass("clicked on Doctor link");
		Doctor_page dc=new Doctor_page(driver);
		dc.clickon_AddDoctor();
		test.pass("clicked on add doctor button");
		dc.enter_DocName(docname);
		test.pass("entered Doctor name");
		dc.enter_Email(e_mail);
		test.pass("entered email id");
		dc.enter_Password(Docpwd);
		test.pass("entered password");
		dc.enter_Phone_no(phone);
		test.pass("entered phone number");
		dc.select_Department(Dname);
		test.pass("selected gynacology department from the drop down");
//		dc.upload_Profile_photo(path);
//		test.pass("successfully uploaded profile photo");
		dc.clickon_Submit();
		test.pass("clicked on submit");
		dc.search_Doc_name(docname);
		test.pass("entered doctor name in search text field");
		dc.verify_doc();
		test.pass("Doctor name is displayed in the list of doctors");
//		ad.clickon_Logout();
//		test.pass("successfully logged out as admin");
		test.info("test ended");
	}
	
	@DataProvider(name = "test data")
	public Object[][] x()
	{
		return Data_provider.getData("Sheet2");
	}
}
