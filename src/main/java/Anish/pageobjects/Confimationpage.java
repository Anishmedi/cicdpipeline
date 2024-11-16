package Anish.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Anish.Abstractcomponents.Abstractcomponents;

public class Confimationpage extends Abstractcomponents {

	WebDriver driver;
	public Confimationpage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement text;
	
	public String confirmMsg() throws InterruptedException 
	{
		Thread.sleep(5000);
		return text.getText();
		
		}

}
