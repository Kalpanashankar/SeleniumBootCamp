package week2.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IndividualSortOrder extends SalesforceBase {
	@Test
	public  void runIndividualSortOrder() throws InterruptedException 
	{
		WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		WebElement nameUparrow = driver.findElement(By.xpath("//span[text()='Name']"));
		driver.executeScript("arguments[0].click();",nameUparrow);
		

	}

}
