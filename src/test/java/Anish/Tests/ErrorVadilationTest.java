package Anish.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Anish.Testcomponents.BaseTest;
import Anish.Testcomponents.Retry;
import Anish.pageobjects.Addcartpage;
import Anish.pageobjects.Cartpage;
import Anish.pageobjects.Confimationpage;
import Anish.pageobjects.LandingpageObjects;
import Anish.pageobjects.OrderPag;
import Anish.pageobjects.Paymentpage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorVadilationTest extends BaseTest {

	String productName = "ZARA COAT 3";
	String countryName = "india";
	@Test(groups= {"errorhandlings"},alwaysRun=true,retryAnalyzer=Retry.class)
	public void errorValid() throws IOException, InterruptedException 
	
	{
		

		Addcartpage addcartpage = landingPageObjects.loginAPP("anishh123@gmail.com", "Anish@123");
		
		Assert.assertEquals("Incorrect email or password.", landingPageObjects.errorMsg());
		
	}
	@Test(alwaysRun=false)
	public void productErroValidation() {
		

		Addcartpage addcartpage = landingPageObjects.loginAPP("anish123@gmail.com", "Anish@123");
		
		Cartpage cartPage = addcartpage.goCart();
	
		
	}
}
