package com.softwaretesting.magneto;
import java.io.Console;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createWishlist {
	@Test
	public void Wishlist() {
	
		System.out.println("Creating wishlist");
		// create driver
	 	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");	
	 	WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		// open test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
		// Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		System.out.println("page is open");
		

		// enter name
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("jimK@yaho.com");

		// enter password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("timKhan@123");
		// click button
		WebElement logInButton = driver.findElement(By.id("send2"));
		logInButton.click();
		sleep(2000);
		// open test page
		String wishUrl = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";
		driver.get(wishUrl);
		sleep(1000);
		System.out.println("page is open");
		// select product
		WebElement wish = driver.findElement(By.xpath(
				"//main[@id='maincontent']//div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/proteus-fitness-jackshirt.html']/span[@class='product-image-container']//img[@alt='Proteus Fitness Jackshirt']"));
		wish.click();
		sleep(2000);
		// new page opens
		// add to wishlist
		WebElement addToWishList = driver.findElement(By.xpath(
				"/html//main[@id='maincontent']//div[@class='product-addto-links']/a[1]/span[.='Add to Wish List']"));
		addToWishList.click();
		// verify msg
		
		 // DOUBT 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  WebElement greenMsg =
			  driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div")); 
			  String expect = "Proteus Fitness Jackshirt has been added to your Wish List. Click here to continue shopping.";
				// Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  String actual = greenMsg.getText();
			  System.out.println(actual);
			  Assert.assertTrue(actual.contains(expect),
			  "Actual error message does not contain expected. \nActual: " + actual +
			  "\nExpected: " + expect); 
			  sleep(1000);
			 
		
		
		// close browser
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