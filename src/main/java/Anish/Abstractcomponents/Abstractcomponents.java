package Anish.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Anish.pageobjects.Cartpage;
import Anish.pageobjects.OrderPag;



public class Abstractcomponents {
	WebDriver driver;

	// constructor
	public Abstractcomponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHead;
	
	By cart=By.cssSelector("[routerlink*='cart']");
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void visibilityProd(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5000));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void invisibilityProd(WebElement ele) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5000));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void visibilityele(WebElement FindBy) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5000));
		w.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void clickable(By findBy) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5000));
		w.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public Cartpage goCart() 
	{
		clickable(cart);
		cartHead.click();
		Cartpage cartPage= new Cartpage(driver);
		return cartPage;
	}
	
	public OrderPag goToOrdersPage()
	{
		visibilityele(orderHeader);
		orderHeader.click();
		OrderPag orderPag=new OrderPag(driver);
		return orderPag;
	}

}
