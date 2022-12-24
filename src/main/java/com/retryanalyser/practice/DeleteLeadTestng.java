package com.retryanalyser.practice;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteLeadTestng extends SalesforceBase{
    @Test(dataProvider = "deleteIndivi")
	public void runDeleteLeadTestng(String search) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(search,Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody/tr[1]/td[6]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Alert deleteAlert = driver.switchTo().alert();
		//deleteAlert.dismiss();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		WebElement deleteNotification = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String notification = deleteNotification.getText();
		System.out.println(notification);
		Assert.assertEquals(notification, "Individual \"kumar\" was deleted. Undo");
		}
    @DataProvider(name="deleteIndivi")
	public String[][] fetchData() throws IOException {
		String[][] data ;
		data = ReadExcelData.readSheetData("DeleteIndivi");
		return data;
    }

}
