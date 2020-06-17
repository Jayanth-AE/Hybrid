package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class File_Manager 
{
	Properties prop;
	public File_Manager()
	{
		try 
		{
			FileInputStream fis = new FileInputStream("./Configuration.properties");
			prop=new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			Reporter.log("property file not found", true);
		}		
	}
	
	public String getQA_url()
	{
		String url = prop.getProperty("QA");
		if (url==null)
		{
			throw new RuntimeException("invalid url");
		}
		return url;
	}
	
	public String getPre_url()
	{
		String url = prop.getProperty("pre");
		if(url==null)
		{
			throw new RuntimeException("url not found");
		}
		return url;
	}
	
	public String getDemo_url()
	{
		String url = prop.getProperty("demo");
		if(url==null)
		{
			throw new RuntimeException("url not found");
		}
		return url;
	}
}