package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyPage {
	
	WebDriver driver;
	
	private By AddAddress_Button = By.xpath("//div[@class='_2Y8lQ1']");
	
	private	By Name_Input = By.xpath("//form/div/div[2]/div[1]/input");
	private By MobileNo_Input = By.xpath("//form/div/div[2]/div[2]/input");
	private By Pin_Input = By.xpath("//form/div/div[3]/div[1]/input");
	private By Locality_Input = By.xpath("//form/div/div[3]/div[2]/input");
	private By Address_Input = By.xpath("//form/div/div[4]/div/div[1]/textarea");
	private By City_Input = By.xpath("//form/div/div[5]/div[1]/div[1]/input");
	private By State_Input = By.xpath("//form/div/div[5]/div[2]/div/div[2]/select");
	private By Save_Button = By.xpath("//form/div/div[8]/button[@class='_2AkmmA EqjTfe _7UHT_c']");
	
	private By OrderSummary_Name = By.xpath("//div[@class='_1Ox9a7']/div[@class='_325-ji']");
	private By OrderSummary_Price = By.xpath("//span[@class='pMSy0p XU9vZa']");
	private By Continue_Button = By.xpath(".//*[@id='to-payment']/button[@class='_2AkmmA _2Q4i61 _7UHT_c']");
	
	private By CardPayment_Radio = By.xpath("//div/label[2]/div[2]/div/div[class='_3i_pKg']");
	private By CardNumber_Input = By.xpath("/input[@class='_16qL6K _366U7Q']");
	private By Month_Select = By.xpath("//select[@class='_1TQIV6 _1E21Zg _8rlsVy']");
	private By Year_Select = By.xpath("//select[@class='_1TQIV6 _1E21Zg']");
	private By CVV_Input= By.xpath("//input[@class='_16qL6K _366U7Q']");
	private By Pay_Button = By.xpath("//button[@class='_2AkmmA wbv91z _7UHT_c']");
	
	public BuyPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement AddAddress_Button()
	{
		return driver.findElement(AddAddress_Button);
	}
	public WebElement Name_Input()
	{
		return driver.findElement(Name_Input);
	}
	public WebElement MobileNo_Input()
	{
		return driver.findElement(MobileNo_Input);
	}
	public WebElement Pin_Input()
	{
		return driver.findElement(Pin_Input);
	}
	public WebElement Address_Input()
	{
		return driver.findElement(Address_Input);
	}
	public WebElement City_Input()
	{
		return driver.findElement(City_Input);
	}
	public WebElement State_Input()
	{
		return driver.findElement(State_Input);
	}
	public WebElement Save_Button()
	{
		return driver.findElement(Save_Button);
	}
	public WebElement Locality_Input()
	{
		return driver.findElement(Locality_Input);
	}
	public WebElement OrderSummary_Name()
	{
		return driver.findElement(OrderSummary_Name);
	}
	public WebElement OrderSummary_Price()
	{
		return driver.findElement(OrderSummary_Price);
	}
	public WebElement CardNumber_Input()
	{
		return driver.findElement(CardNumber_Input);
	}
	public WebElement Month_Select()
	{
		return driver.findElement(Month_Select);
	}
	public WebElement Year_Select()
	{
		return driver.findElement(Year_Select);
	}
	public WebElement CVV_Input()
	{
		return driver.findElement(CVV_Input);
	}
	public WebElement Pay_Button()
	{
		return driver.findElement(Pay_Button);
	}
	public WebElement CardPayment_Radio()
	{
		return driver.findElement(CardPayment_Radio);
	}
	public WebElement Continue_Button()
	{
		return driver.findElement(Continue_Button);
	}
	
	
	

}
