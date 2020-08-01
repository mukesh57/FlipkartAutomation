package Flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	public static WebDriver driver;
	public Properties pro;
	File src;
	public WebDriver initializeDriver() throws IOException
	{
		
		pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		pro.load(fis);
		String BrowserName = pro.getProperty("Browser");
		System.out.println(BrowserName);
		
		//Browser conditions
		if(BrowserName.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (BrowserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	

	
}
