package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	private By UserMailOrMobileNo_Input = By.xpath("//div[2]//form/div[1]/input[@type='text']");
	private By UserPassword_Input = By.xpath("//div[2]//form/div[2]/input[@type='password']");
	private By Login_Button = By.xpath("//div[2]//form/div[3]/button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement UserMailOrMobileNo_Input()
	{
		return driver.findElement(UserMailOrMobileNo_Input);
	}
	
	public WebElement UserPassword_Input()
	{
		return driver.findElement(UserPassword_Input);
	}
		
	public WebElement Login_Button()
	{
		return driver.findElement(Login_Button);
	}
	

}
