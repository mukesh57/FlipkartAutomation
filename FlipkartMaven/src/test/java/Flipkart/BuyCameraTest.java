package Flipkart;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.BuyPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductDecPage;

public class BuyCameraTest extends Base {

	public static WebDriver driver;
	
	@BeforeClass
	public void LoginPageNavigation() throws IOException
	{
		driver = initializeDriver();
		driver.get(pro.getProperty("URL"));
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 0)
	public void LoginTest() throws InterruptedException
	{
		try {
		LoginPage Login_Object = new LoginPage(driver);
		Login_Object.UserMailOrMobileNo_Input().sendKeys(pro.getProperty("UserName")); //GIVE CORRECT UserName IN PROPERTIES FILE
		Login_Object.UserPassword_Input().sendKeys(pro.getProperty("Password"));	//GIVE CORRECT Password IN PROPERTIES FILE
		Login_Object.Login_Button().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage Home_Object = new HomePage(driver);
		if(!Home_Object.UserName_Text().getText().equals(pro.getProperty("UserDisplayName")) ) //GIVE expected UserNameDiplay IN PROPERTIES FILE
			Assert.fail("Login Fail- UserName not match");
		}
		catch(NoSuchElementException e){
			Assert.fail("Login Fail- UserName or Password not correct");
		}
	}
	
	@Test(priority = 1)
	public void SearchCameraTest() throws InterruptedException
	{
		try {
		HomePage Home_Object = new HomePage(driver);
		Home_Object.Search_Input().sendKeys(pro.getProperty("SearchItem"));
		Home_Object.Search_Button().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Select Product w.r.t
		//1. Product Rating- Highest
		//2. Product Name - Canon

		//Fetch All the Products Text
		List<WebElement> list_of_products = Home_Object.ProductNameList_Link();
		List<WebElement> list_of_products_rating = Home_Object.ProductRatingList_Link();
		
		//TreeMap to store sorting product rating and there names(also converting to integer)
		String product_name;
		String product_rating;
		int int_product_rating;
		String product_dec = "";
		TreeMap<Integer, String> map_final_products = new TreeMap<Integer,String>();
		for(int i=0;i<list_of_products.size()-1;i++) {
			product_name = list_of_products.get(i).getText();
			product_rating = list_of_products_rating.get(i).getText();
			product_rating = product_rating.replaceAll("[^0-9]", "");//only taking integer from price
			int_product_rating = Integer.parseInt(product_rating);//Convert to Integer
			if(product_name.contains(pro.getProperty("ProductDec")))
				map_final_products.put(int_product_rating,product_name);//Add Only Canon product to HashMap
		}
		// to arrange in rating descending order
		Map<Integer,String> Descending_map_final_products = new TreeMap<Integer,String>(Collections.reverseOrder());
		Descending_map_final_products.putAll(map_final_products);
		
		// getting product description which contain Cannon and highest rating
		for(Integer i:Descending_map_final_products.keySet())
		{
			if(Descending_map_final_products.get(i).contains(pro.getProperty("ProductDec")))
			{
				product_dec += Descending_map_final_products.get(i);
				break;
			}
		}
		
		// Select product
		for(int i=0 ;i<list_of_products.size()-1;i++)
		{
			if(list_of_products.get(i).getText().equals(product_dec))
			{
				list_of_products.get(i).click();
				break;
			}
		}
		}
		catch(NoSuchElementException e){
			Assert.fail("Search Camera fail");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	 @Test(priority = 2)
	 public void AddToCartTest(ITestContext context) throws InterruptedException
	 {
		 try {
		 //Windows Handler 
		 String parentWindowHandle = driver.getWindowHandle();
		 Set<String> allWindowHandles = driver.getWindowHandles();
		 String LastWindow = "";
		 for(String handle : allWindowHandles)
		 {
			 LastWindow = handle;
		 }
		 driver.switchTo().window(LastWindow);//Switching to second window 
		 // storing parent and new window handle ID
		 context.setAttribute("parentWindowHandle", parentWindowHandle);
		 context.setAttribute("LastWindow", LastWindow);
		 
		 ProductDecPage ProductDec_Object = new ProductDecPage(driver);
		 String ProductName = ProductDec_Object.ProductName_Text().getText();
		 String ProductPrice= ProductDec_Object.ProductPrice_Text().getText();
		 ProductPrice = ProductPrice.replaceAll("[^0-9]", "");//removing space and special char from price
		 context.setAttribute("ProductName", ProductName);
		 context.setAttribute("ProductPrice", ProductPrice);
		 //Add to cart
		 ProductDec_Object.AddToCart_Button().click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 ProductDec_Object.PlaceOrder_Button().click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
		 catch(NoSuchElementException e){
				Assert.fail("Add to Cart Fail");
		}
	 } 
	 
	 @Test(priority = 3)
	 public void BuyNowTest(ITestContext context) throws InterruptedException
	 {
		 try {
		 //Windows Handler 
		 String LastWindow = (String) context.getAttribute("LastWindow");
		 driver.switchTo().window(LastWindow);//Switching to second window 
		 
		 BuyPage Buy_Object = new BuyPage(driver);
		 Buy_Object.AddAddress_Button().click();
		 Buy_Object.Name_Input().sendKeys(pro.getProperty("AddName"));
		 Buy_Object.MobileNo_Input().sendKeys(pro.getProperty("AddMobile"));
		 Buy_Object.Pin_Input().sendKeys(pro.getProperty("AddPin"));
		 Buy_Object.Locality_Input().sendKeys(pro.getProperty("AddLocality"));
		 Buy_Object.Address_Input().sendKeys(pro.getProperty("Address"));
		 Buy_Object.Save_Button().click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //Order summary- VALIDATION  Of Product name and price
		 String PName = Buy_Object.OrderSummary_Name().getText();
		 String PPrice = Buy_Object.OrderSummary_Price().getText();
		 PPrice = PPrice.replaceAll("[^0-9]", "");//removing space and special char from price
		 String ProductName = (String) context.getAttribute("ProductName");
		 String ProductPrice = (String) context.getAttribute("ProductPrice");
		 Assert.assertTrue(ProductName.contains(PName), "Product Name match check");
		 Assert.assertEquals(PPrice, ProductPrice, "Product price match check");
		 Buy_Object.Continue_Button().click();
		 
		 //Card Payment
		 Buy_Object.CardPayment_Radio().click();
		 Buy_Object.CardNumber_Input().sendKeys(pro.getProperty("CardNumber"));
		 Select month = new Select( Buy_Object.Month_Select());
		 month.selectByVisibleText(pro.getProperty("month"));
		 Select year = new Select( Buy_Object.Year_Select());
		 year.selectByVisibleText(pro.getProperty("year"));
		 Buy_Object.CVV_Input().sendKeys(pro.getProperty("CVV"));
		 Buy_Object.Pay_Button(); 
		 //closing newly open tab
		 driver.close();
		 }
		 catch(NoSuchElementException e){
				Assert.fail("BuyNow Fail");
		}
	 }
	
	@Test(priority = 4)
	public void LogoutTest(ITestContext context) throws InterruptedException
	{
		try { 
		//Windows Handler 
		 String parentWindowHandle = (String) context.getAttribute("parentWindowHandle");
		 driver.switchTo().window(parentWindowHandle);//Switching to second window 
		
		//Mouse hover
		Actions actions = new Actions(driver);
		HomePage Home_Object = new HomePage(driver);
		actions.moveToElement(Home_Object.UserName_Text()).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home_Object.Logout_Button().click();
		}
		catch(NoSuchElementException e){
			Assert.fail("Logout Fail");
		}

		
	}
	
	@AfterClass
	public void BrowserQuit()
	{
		driver.quit();
	}
	
}
