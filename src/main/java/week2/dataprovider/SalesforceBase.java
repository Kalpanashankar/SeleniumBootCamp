package week2.dataprovider;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceBase {
	public ChromeDriver driver;
      //@Parameters({"url","username","password"})
	  @BeforeMethod
	  public void preCondition() throws InterruptedException {
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			
			driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//login
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kalpanashankar1997@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shankar@123");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='App Launcher']/preceding::div[@class='slds-icon-waffle']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(5000);
			WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			act.moveToElement(individuals)
			.click()
			.build()
			.perform();
			
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
		  driver.close();
	  }

	}



