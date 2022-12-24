package week2.dataprovider;  
import java.io.IOException;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatIndivtestng extends SalesforceBase {
	@Test(dataProvider="createIndivi")
	public void runCreateIndividuals(String lastName) throws InterruptedException 
	{
		Thread.sleep(20000);
		WebElement individualDropdown = driver.findElement(By.xpath("(//span[text()='Individuals']/following::lightning-icon)[1]"));
		driver.executeScript("arguments[0].click();",individualDropdown);
		//individualDropdown.click();
		
		Thread.sleep(5000);
		WebElement newIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();",newIndividual);
		Thread.sleep(5000);
		WebElement lastName1 = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
		lastName1.sendKeys(lastName);
		
		driver.findElement(By.xpath("//button[@title='Save']/span")).click();
		String lastName2 = (driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText());
		Assert.assertEquals(lastName2, "kumar");
	}
	@DataProvider(name="createIndivi")
	public String[][] fetchData() throws IOException {
		String[][] data ;
		data = ReadExcelData.readSheetData("CreateLead");
		return data;
}
}
		
		
		
		
		
		
		
		
	

	

		
		
		
		
		

	

