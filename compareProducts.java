package com.softwaretesting.magneto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class compareProducts {
	@Test
	public void compare() {
		System.out.println("Comparing products");
		// create driver
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");	
		WebDriver driver = new ChromeDriver();

		// maximize
		driver.manage().window().maximize();

		// open login test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
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
		
		// open any section
		String url1 = "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html";
		driver.get(url1);
		
		// add product 1 in compare list
		WebElement product1 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/olivia-1-4-zip-light-jacket.html']/span[@class='product-image-container']//img[@alt='Olivia 1/4 Zip Light Jacket']"));
		product1.click();
		WebElement add1 = driver.findElement(By.xpath("/html//main[@id='maincontent']//div[@class='product-addto-links']/a[2]/span[.='Add to Compare']"));
		add1.click();
		sleep(2000);
		
		// add product 2 in compare list
		String url2 = "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html";
		driver.get(url2);
		WebElement product2 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@class='column main']/div[3]/ol/li[4]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/nadia-elements-shell.html']/span[@class='product-image-container']//img[@alt='Nadia Elements Shell']")); 
		product2.click();
		WebElement add2 = driver.findElement(By.xpath("/html//main[@id='maincontent']//div[@class='product-addto-links']/a[2]/span[.='Add to Compare']"));
		add2.click();
		sleep(2000);
		//  compare list
		String url3 = "https://magento.softwaretestingboard.com/catalog/product_compare/index/uenc/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9zZWN0aW9uL2xvYWQvP3NlY3Rpb25zPWNvbXBhcmUtcHJvZHVjdHMlMkNtZXNzYWdlcyZmb3JjZV9uZXdfc2VjdGlvbl90aW1lc3RhbXA9ZmFsc2UmXz0xNjc3NzUwMzYyNDYz/";
		 driver.get(url3);
	    
		// verfiy
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