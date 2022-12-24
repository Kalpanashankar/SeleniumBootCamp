package w1.day1.salesforce8;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividuals {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(individuals)
		.click()
		.build()
		.perform();
		Thread.sleep(5000);
		WebElement individualDropdown = driver.findElement(By.xpath("(//span[text()='Individuals']/following::lightning-icon)[1]"));
		driver.executeScript("arguments[0].click();",individualDropdown);
		//individualDropdown.click();
		
		Thread.sleep(5000);
		WebElement newIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();",newIndividual);
		Thread.sleep(5000);
		WebElement lastName = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
		lastName.sendKeys("kumar");
		
		driver.findElement(By.xpath("//button[@title='Save']/span")).click();
		
		//verify
		String givenLastName = "kumar";
		String lastName1 = (driver.findElement(By.xpath("//div[text()='Individual']/following::span[1]")).getText());
		System.out.println(lastName1);
		if(givenLastName.equals(lastName1))
		{
			System.out.println("New Individual saved successfully");
			
		}
		else
		{
			System.out.println("New Individual not saved successfully");
			
		}
		
	}
}


	

		
		
		
		
		

	


