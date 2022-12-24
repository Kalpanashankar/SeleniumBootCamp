package w1.day1.salesforce8;

import java.time.Duration;


//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIndividuals {

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
		WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys("Kumar",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody/tr[1]/td[6]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Alert deleteAlert = driver.switchTo().alert();
		//deleteAlert.dismiss();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String expectedNotification = "Individual \"kumar\" was deleted. Undo";
		WebElement deleteNotification = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String notification = deleteNotification.getText();
		System.out.println(notification);
		//Assert.assertEquals(deleteNotification, "Individual \"kumar\" was deleted. Undo");
		if(notification.equals(expectedNotification))
		{
			System.out.println("deleted");
		}
		else
			System.out.println("NotDeleted");
	}

}
