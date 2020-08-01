package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	private By UserName_Text = By.xpath(".//*[@id='container']//div[3]//div[@class='_2aUbKa']");
	private By Search_Input = By.xpath("//input[@class='LM6RPg']");
	private By Search_Button = By.xpath("//button[@class='vh79eN']");
	private By Logout_Button = By.xpath(".//*[@id='container']//ul/li[10]/a/div[@class='_1Q5BxB']");
	private By SearchResult_Text = By.xpath("//div[@class='_3UEiDE']/div[@class='_1joEet']/div[3]/a[@class='_1KHd47']");
	private By ProductNameList_Link = By.xpath(".//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]//div[@class='_3wU53n']");
	private By ProductPriceList_Link = By.xpath("//div[@class='_1vC4OE _2rQ-NK']");
	private By ProductRatingList_Link = By.xpath("//div[@class='hGSR34']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement UserName_Text()
	{
		return driver.findElement(UserName_Text);
	}
	public WebElement Search_Input()
	{
		return driver.findElement(Search_Input);
	}
	public WebElement Search_Button()
	{
		return driver.findElement(Search_Button);
	}
	public WebElement Logout_Button()
	{
		return driver.findElement(Logout_Button);
	}
	public WebElement SearchResult_Text()
	{
		return driver.findElement(SearchResult_Text);
	}
	public List<WebElement> ProductNameList_Link()
	{
		return driver.findElements(ProductNameList_Link);
	}
	public List<WebElement> ProductPriceList_Link()
	{
		return driver.findElements(ProductPriceList_Link);
	}
	public List<WebElement> ProductRatingList_Link()
	{
		return driver.findElements(ProductRatingList_Link);
	}

}
