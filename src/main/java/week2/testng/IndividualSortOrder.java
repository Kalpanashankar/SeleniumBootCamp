package week2.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndividualSortOrder extends SalesforceBase {

	public  void runIndividualSortOrder() throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		WebElement nameUparrow = driver.findElement(By.xpath("//span[text()='Name']"));
		driver.executeScript("arguments[0].click();",nameUparrow);
		

	}

}
