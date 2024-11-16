package Anish.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Anish.Abstractcomponents.Abstractcomponents;

public class Addcartpage extends Abstractcomponents {
	WebDriver driver;

	public Addcartpage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> getProdlist;

	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By prodBy = By.cssSelector(".mb-3");
	By addCart= By.cssSelector(".card-body button:last-of-type");
	By toastMsg =By.cssSelector("#toast-container");

	public  List<WebElement> getProdlist() 
	{
		visibilityProd(prodBy);
		return getProdlist;
	}
	public WebElement prodName(String productName) 
	{
		WebElement prod =getProdlist().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
	}
	
	public void addProductTocart(String productName )
	
	{
		WebElement prod= prodName(productName);
		prod.findElement(addCart).click();
		visibilityProd(toastMsg);
		invisibilityProd(spinner);

	}
	

}
