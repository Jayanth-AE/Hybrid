package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser_Factory implements Auto_const
{
	//static represents single copy
	private Map<String, WebDriver> add=new HashMap<String, WebDriver>();
		//non static method because to create multiple instances	
	public WebDriver open_Browser(String browser_name)
	{
		WebDriver driver=null;
		switch(browser_name)
		{
		case "chrome":
			driver=add.get("chrome");
			if(driver==null)
			System.setProperty(chrome_key, chrome_value);
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
			add.put("chrome", driver);
		break;
		
		case "firefox":
		driver=add.get("firefox");
		if(driver==null)
			System.setProperty(gecko_key, gecko_value);
			FirefoxOptions opt1=new FirefoxOptions();
			opt1.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(opt1);
			add.put("firfox", driver);
		break;
		
		case "edge":
			driver=add.get("edge");
			if(driver==null)
				System.setProperty(edge_key, edge_value);
				driver=new EdgeDriver();
				add.put("edge", driver);
		default:
			System.out.println("invalid browser");
			break;
		}
		return driver;
	}
	public void close_Browser()
	{
		for(String key:add.keySet())
		{
			add.get(key).quit();
		}
	}
}
