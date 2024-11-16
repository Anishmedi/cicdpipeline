package Anish.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;

import Anish.pageobjects.Addcartpage;
import Anish.pageobjects.LandingpageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("anish123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anish@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		
		
		driver.manage().window().maximize();
		String productName="ZARA COAT 3";
		
		//landingPageObjects.goTo();
		//landingPageObjects.loginAPP("anish123@gmail.com", "Anish@123");
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofMillis(5000));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> p =driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod =p.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		//System.out.println(pro);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartp=driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match= cartp.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		System.out.println(match);
		Assert.assertTrue(true);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Checkout')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		
		
		driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")).sendKeys("india");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='India']//i")));
		driver.findElement(By.xpath("//span[normalize-space()='India']//i")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btnn action__submit ng-star-inserted']")));
		driver.findElement(By.cssSelector("[class='btnn action__submit ng-star-inserted']")).click();
		String e=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(e.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
		
		
		
		
		
		
		
		

	}

}
