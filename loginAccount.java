package com.softwaretesting.magneto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class loginAccount {

	@Test
public void login() {
		System.out.println("Starting login test");
		//Create driver
	 	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		//sleep
		//sleep(1000);
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize window
		driver.manage().window().maximize();
		//open test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
	    sleep(1000);
		System.out.println("page is open");
		
		//enter name
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("yaaniK@yaho.com");
		
		//enter password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("timKhan@123");
		//click button
		WebElement logInButton = driver.findElement(By.id("send2"));
		logInButton.click();
		sleep(2000);
		//verify new url
		String expectedUrl = "https://magento.softwaretestingboard.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		
		
		//close browser
		driver.quit();
}
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}