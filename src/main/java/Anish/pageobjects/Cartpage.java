package Anish.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anish.Abstractcomponents.Abstractcomponents;

public class Cartpage extends Abstractcomponents {


	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath=".cartSection h3")
	List<WebElement> carList;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout;
	
	By check=By.xpath("//button[contains(text(),'Checkout')]");
	
		public List<WebElement> getListCart()
		{
			return carList;
		}
		public Boolean cartNames(String productName ) 
		{
			
			boolean match= getListCart().stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
			return match;
		}
		public Paymentpage  checkOut()
		{
			clickable(check);
			checkout.click();
			return new Paymentpage(driver);
			
			
		}

	

	}


