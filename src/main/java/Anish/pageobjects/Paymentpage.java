package Anish.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Anish.Abstractcomponents.Abstractcomponents;

public class Paymentpage extends Abstractcomponents {
	
	WebDriver driver;
	
	public Paymentpage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css ="[placeholder=\"Select Country\"]")
	WebElement country;
	
	By waitCountry =By.xpath("//span[normalize-space()='India']//i");
	
	By waitPalace=By.cssSelector("[class='btnn action__submit ng-star-inserted']");
	
	
	@FindBy(xpath ="//span[normalize-space()='India']//i")
	WebElement selectCountry;
	
	@FindBy(css="[class='btnn action__submit ng-star-inserted']")
	WebElement placeOrder;
	
	
	
	public void selectCOuntry(String countryName) 
	{
		Actions a =new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		clickable(waitCountry);
		selectCountry.click();
		
	}
	public Confimationpage placeOder()
	{
		clickable(waitPalace);
		placeOrder.click();
		return new Confimationpage(driver);
	}
	
}
