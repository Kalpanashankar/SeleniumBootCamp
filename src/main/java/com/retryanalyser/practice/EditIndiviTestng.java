package com.retryanalyser.practice;
import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.Assert;
import org.testng.annotations.Test;


public class EditIndiviTestng extends SalesforceBase {
    @Test(dataProvider="EditIndivi")
	public void runEditIndividuals(String search, String firstName) throws InterruptedException 
	{
		// TODO Auto-generated method stub
    	Thread.sleep(5000);
        WebElement individualTab = driver.findElement(By.xpath("//a[@title='Individuals']//span"));
		driver.executeScript("arguments[0].click();",individualTab);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(search,Keys.ENTER);
		Thread.sleep(5000);
		
		//WebElement dropDown = driver.findElement(By.xpath("//a[@title='Show 2 more actions']"));
		driver.findElement(By.xpath("//div[@class='uiVirtualDataTable indicator']/following::table/tbody/tr[1]/td[6]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("(//span[text()='Salutation']/following::a[text()='--None--'])[1]")).click();
	    driver.findElement(By.xpath("//a[text()='Mr.']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    WebElement editNotification = driver.findElement(By.xpath("//span[contains(@class,'forceActionsText')]"));
		String notification = editNotification.getText();
		System.out.println(notification);
		Assert.assertEquals(notification, "Individual \"ganesh kumar\" was saved.");

	}
    @DataProvider(name="EditIndivi")
	public String[][] fetchData() throws IOException {
		String[][] data ;
		data = ReadExcelData.readSheetData("EditLead");
		return data;
    }
	
	

	}

