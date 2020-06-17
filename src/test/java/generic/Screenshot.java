package generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshot 
{
	//non static method because we want multiple screen shots of multiple browser
	public String capture(WebDriver driver, String TC)
	{
		Date d1=new Date();
		String d2 = d1.toString();
		String date = d2.replace(":", "-");
		String path=System.getProperty("user.dir")+"./defects/"+date+TC+".png";
					// (. represents current working directory of  the project)
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(path);
		
		try		
		{
			FileHandler.copy(src, dst);
		}
		catch(Exception e)
		{
			Reporter.log("failed to take the screenshot", true);
		}
		return path;
	}
}