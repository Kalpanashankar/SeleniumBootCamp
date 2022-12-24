package w1.day1.salesforce8;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualSortOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		Thread.sleep(5000);
		Thread.sleep(5000);
		WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		WebElement nameUparrow = driver.findElement(By.xpath("//span[text()='Name']"));
		driver.executeScript("arguments[0].click();",nameUparrow);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody/tr"));
		int rowCount = rows.size();
		System.out.println(rowCount);
		List<WebElement> columns = driver.findElements(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody//th"));
		int colCount = columns.size();
		System.out.println(colCount);
		for(int i=1; i <= rowCount; i++) {
			
				Thread.sleep(20000);
				String value = driver.findElement(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody/tr["+i+"]/th[1]")).getText();
				System.out.println(value);
			    
		}
				
		}
	}


