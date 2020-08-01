package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDecPage {
	
	WebDriver driver;
	
	private By ProductName_Text = By.xpath("//h1[@class='_9E25nV']/span[@class='_35KyD6']");
	private By ProductPrice_Text = By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
	private By AddToCart_Button = By.xpath("//div/ul/li[1]/button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	private By PlaceOrder_Button = By.xpath("//div/form/button[@class='_2AkmmA iwYpF9 _7UHT_c']");
	
	public ProductDecPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement ProductName_Text()
	{
		return driver.findElement(ProductName_Text);
	}
	public WebElement ProductPrice_Text()
	{
		return driver.findElement(ProductPrice_Text);
	}
	public WebElement AddToCart_Button()
	{
		return driver.findElement(AddToCart_Button);
	}
	public WebElement PlaceOrder_Button()
	{
		return driver.findElement(PlaceOrder_Button);
	}

}
