package w1.day1.salesforce8;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S1_CreateNewOpp {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
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
		
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(sales)
		.click()
		.build()
		.perform();
		Thread.sleep(5000);
		
		List<WebElement> tabList = driver.findElements(By.xpath("//a[@role='button']"));
		for(WebElement tabNames:tabList)
			
		{
			String listOftabName = tabNames.getText();
			System.out.println(listOftabName);
			if(listOftabName.equals("Opportunities Menu"));
			{
				driver.executeScript("arguments[0].click();",tabNames);
				break;
			}
		}
		    Thread.sleep(20000);
			WebElement newOpportunity = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
			driver.executeScript("arguments[0].click();",newOpportunity);
			//WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
			//closeDate.sendKeys("12202022");
			List<WebElement> newOppPageElement = driver.findElements(By.xpath("//span[text()='New Opportunity']"));
			for(WebElement newOppPageElements:newOppPageElement)
			{
				String newOppPageAllElements = newOppPageElements.getText();
				System.out.println(newOppPageAllElements);
				/*if(newOppPageAllElements.equals("Opportunity Name"))
				{
					
				}
				if(newOppPageAllElements.equals("Stage"));
				{
					driver.executeScript("arguments[0].click();",newOppPageElements);
					break;
				}*/
			
		}
			
			
			
			
			
			
		

	   
	}

}
