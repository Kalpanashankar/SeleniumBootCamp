package week2.testng;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IndiviWithoutMandatoryTestng extends SalesforceBase{
    @Test
	public  void runIndiviWithoutMandatoryTestng() throws InterruptedException {
		// TODO Auto-generated method stub
		
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
	   
	    WebElement actualErrorMessage = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Last Name']"));
	    String errorMessage = actualErrorMessage.getText();
	    System.out.println(errorMessage);
	    Assert.assertEquals(errorMessage, "These required fields must be completed: Last Name");
	   



	}

}
