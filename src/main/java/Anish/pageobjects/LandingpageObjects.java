package Anish.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anish.Abstractcomponents.Abstractcomponents;

public class LandingpageObjects extends Abstractcomponents{

	WebDriver driver;

	public LandingpageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement uemail;

	@FindBy(id = "userPassword")
	WebElement uPassword;

	@FindBy(xpath = "//input[@id='login']")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public  Addcartpage loginAPP(String email, String Password) {

		uemail.sendKeys(email);
		uPassword.sendKeys(Password);
		login.click();
		Addcartpage addcartpage = new Addcartpage(driver);
		return addcartpage;
	}
	public String errorMsg() {
		visibilityele(errorMessage);
		return errorMessage.getText();
		

	}
}
