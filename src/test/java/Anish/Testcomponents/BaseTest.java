package Anish.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

import Anish.pageobjects.LandingpageObjects;

public class BaseTest {

	public  WebDriver driver;
	public LandingpageObjects landingPageObjects;
	public  WebDriver initilazeDriver() throws IOException 
	{
		Properties prop =new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Anish\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")) 
		{
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")){
				driver.manage().window().setSize(new Dimension(1440,900));
			options.addArguments("headless");
			}
			 driver = new ChromeDriver(options);
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			//WebDriver driver = new geckoDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("edge")){
			 driver = new EdgeDriver();
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.manage().window().maximize();
		return driver;
		
	
}
	
	
	public  String getScreenshot(String testCasename,WebDriver driver) throws IOException {
		 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = System.getProperty("user.dir") + "//reports//"+ testCasename+ ".png";
	        File destFile = new File(path);
	        FileUtils.copyFile(srcFile, destFile);
	        return path;
	        }
	
	
public List<HashMap<String,String>>getdataTomap(String filepath) throws IOException{
	String jsonContent = 	FileUtils.readFileToString(new File(filepath), 
			StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	return data;
	
}
	
	@BeforeMethod(alwaysRun=true)
	public   LandingpageObjects launchApllication() throws IOException 
	{
		driver=initilazeDriver();
		 landingPageObjects = new LandingpageObjects(driver);
		landingPageObjects.goTo();
		return landingPageObjects;
		
		
	}
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
}
