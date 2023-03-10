package com.selenium.test_my_adderessbook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        //load driver or set location of driver
    	System.setProperty("webdriver.chrome.driver", "/home/praveen/Downloads/chromedriver_linux64/chromedriver");
    	 
    	//object of chrome options
    	ChromeOptions chromeOptions = new ChromeOptions();
    	//pass the varibale to the driver
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	
    	System.out.println("selenium test case started");
    	
    	// open the web browser and enter application url
    	driver.get("http://localhost:8080/addressbook/");
    	
    	//wait for page to load
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	//click on new contact button
    	 driver.findElement(By.className("v-button")).click();
    	
    	//enter all the details
    	driver.findElement(By.id("gwt-uid-5")).sendKeys("Praveen");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-7")).sendKeys("Sirvi");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-9")).sendKeys("9116422139");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-11")).sendKeys("sirvi@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-13")).sendKeys("3/8/23,");
    	Thread.sleep(1000);
    	
    	//click on save 
    	driver.findElement(By.className("v-button-primary")).click();
    	
    	Thread.sleep(1000);
    	
    	//verify the saved data or took a screenshot
    	TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	
    	File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
    	
    	File destFile = new File("//home//praveen//Pictures//test.png"); 
    	
    	FileUtils.copyFile(scrFile, destFile); 
    	
    	Thread.sleep(5000);
    	//quite the driver
    	driver.quit();
    	
    	System.out.println("Test cases executed");
    }
}
