package Anish.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Anish.Testcomponents.BaseTest;
import Anish.pageobjects.Addcartpage;
import Anish.pageobjects.Cartpage;
import Anish.pageobjects.Confimationpage;
import Anish.pageobjects.LandingpageObjects;
import Anish.pageobjects.OrderPag;
import Anish.pageobjects.Paymentpage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitOrderTest<object> extends BaseTest {
	
	
	String countryName = "india";
	@Test(dataProvider="getData1")
	public void submitOrder(HashMap<String, String>input) throws IOException, InterruptedException 
	
	{
		
		
		Addcartpage addcartpage = landingPageObjects.loginAPP(input.get("email"), input.get("pass"));
		addcartpage.addProductTocart(input.get("productName"));
		Cartpage cartPage = addcartpage.goCart();
		Paymentpage paymentPage = cartPage.checkOut();
		paymentPage.selectCOuntry(countryName);
		Confimationpage confimationPage = paymentPage.placeOder();
		String msg = confimationPage.confirmMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
	}
	
	
	
	
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData1")
	public void OrderHistory(HashMap<String, String>input) {
		
		Addcartpage addcartpage = landingPageObjects.loginAPP(input.get("email") ,input.get("pass"));
		OrderPag orderPages=addcartpage.goToOrdersPage();
		Assert.assertTrue(orderPages.VerifyOrderDisplay(input.get("productName")));
		
	
	
	
}
	
	

		
	@DataProvider
	public Object[][] getData1() throws IOException

	{
		
		List<HashMap<String,String>> data = getdataTomap(System.getProperty("user.dir")+"\\\\src\\\\test\\\\java\\\\Anish\\\\Dataset\\\\data.json\\");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
		
	
		
		/*return new object[][] {{"anish123@gmail.com","Anish@123","ZARA COAT 3"},{"anish0001@gmail.com","Anish@123","ADIDAS ORIGINAL"}}
		
		HashMap<String, String> map = new HashMap<>();
        map.put("email", "anish123@gmail.com");
        map.put("pass", "Anish@123");
        map.put("productName", "ZARA COAT 3");
        
        // Creating the second data set
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "anish0001@gmail.com");
        map1.put("pass", "Anish@123");
        map1.put("productName", "ADIDAS ORIGINAL");
        
        // Returning the data as an Object[][] array
        return new Object[][] { { map }, { map1 } };
	*/
	
	}}





