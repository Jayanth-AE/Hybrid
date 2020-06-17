package generic;


import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Generic_test
{
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;	//to specify the path of reports
	public static ExtentReports reports;			//intern it consists of path
	public static ExtentTest test;					//to log the status of each steps
	public Logger log=Logger.getLogger(Generic_test.class);
	
	
	@BeforeSuite
	public void setup()
	{
		htmlReporter=new ExtentHtmlReporter("./Ereports/"+new Date().toString().replace(":","-")+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void open_app(@Optional("chrome")String browser)//@optional-->default
	{
		log.info("browser is launching");
		if(browser.equals("chrome"))
		{
			driver=new Browser_Factory().open_Browser("chrome");
			driver.get(new File_Manager().getQA_url());
		}
		
		else if (browser.equals("firefox"))
		{
			driver=new Browser_Factory().open_Browser("firefox");
			driver.get(new File_Manager().getQA_url());
		}
		
		else
		{
			driver=new Browser_Factory().open_Browser("edge");
			driver.get(new File_Manager().getQA_url());
		}
	}
	
	@AfterMethod
	public void close_app(ITestResult a) throws IOException
	{
		if(ITestResult.FAILURE==a.getStatus())
		{
			String TC_name="  "+a.getName();//test case name
			//Screenshot.capture(driver,TC_name);
			
			test.fail("test case failed", MediaEntityBuilder.createScreenCaptureFromPath(new Screenshot().capture(driver, TC_name)).build());
										//its a class used to attach the screenshot																					//used to trigger the event
		}
		test.assignAuthor("Jay");
		test.assignDevice("Dell laptop");
		test.assignCategory("Gui Automation");
		reports.setSystemInfo("windows", "10");
		new Browser_Factory().close_Browser();
		log.info("browser is closed");
	}
	
	@AfterSuite
	public void teardown()
	{
		reports.flush();
	}
}