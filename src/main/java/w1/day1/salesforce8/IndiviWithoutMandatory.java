package w1.day1.salesforce8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndiviWithoutMandatory {

	public static void main(String[] args) throws InterruptedException
	{
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
		WebElement individualDropdown = driver.findElement(By.xpath("(//span[text()='Individuals']/following::lightning-icon)[1]"));
		driver.executeScript("arguments[0].click();",individualDropdown);
		Thread.sleep(5000);
		WebElement newIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();",newIndividual);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='Salutation']/following::a[text()='--None--'])[1]")).click();
	    driver.findElement(By.xpath("//a[text()='Mr.']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ganesh");
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    //String expectedErrorMessage = "Review the errors on this page.";
	    String expectedErrorMessage1= "These required fields must be completed: Last Name";
	    //WebElement actualErrorMessage = driver.findElement(By.xpath("//div[@class='genericNotification']"));
	   // actualErrorMessage.getText();
	    //System.out.println(actualErrorMessage);
	    WebElement actualErrorMessage1 = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Last Name']"));
	    actualErrorMessage1.getText();
	    System.out.println(actualErrorMessage1);
	    if(expectedErrorMessage1.equals(actualErrorMessage1))
	    {
	    	System.out.println("error message displayed");
	    }
	    else
	    {
	    	System.out.println("Not displayed error message");
	    }

	}

}
