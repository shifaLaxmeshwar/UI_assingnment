package com.softwaretesting.magneto;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class myAccountOrders {
	@Test
	public void accountOrders() {
		// create driver
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// maximize
		driver.manage().window().maximize();
		// open login page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
		System.out.println("page is open");
		// login
		// enter name
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("jimK@yaho.com");

		// enter password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("timKhan@123");

		// click button
		WebElement logInButton = driver.findElement(By.id("send2"));
		logInButton.click();

		// navigate to my account page
		String url2 = "https://magento.softwaretestingboard.com/sales/order/history/";
		driver.get(url2); //

		// validate
		//order1
		WebElement order1 = driver
				.findElement(By.xpath("/html//table[@id='my-orders-table']/tbody/tr[1]/td[@class='col id']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ExpectedOrder1 = "000021189";
		String actualOrder1 = order1.getText();
		System.out.println("order " + actualOrder1);

		Assert.assertTrue(actualOrder1.contains(ExpectedOrder1),
				"Actual error message does not contain expected. \nActual: " + actualOrder1 + "\nExpected: "
						+ ExpectedOrder1);
		
		//date
		WebElement date1 = driver.findElement(By.cssSelector("tbody tr:nth-of-type(1) .date"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Expecteddate1 = "3/3/23";
		String actualdate1 = date1.getText();
		System.out.println("date " + actualdate1);
		Assert.assertTrue(actualdate1.contains(Expecteddate1),
				"Actual error message does not contain expected. \nActual: " + actualdate1 + "\nExpected: "
						+ Expecteddate1);
		
		//ship
		WebElement ship1 = driver.findElement(By.xpath("/html//table[@id='my-orders-table']/tbody/tr[1]/td[@class='col shipping']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Expectedship1 = "Shifa lax";
		String actualship1 = ship1.getText();
		System.out.println("ship " + actualship1);
		Assert.assertTrue(actualship1.contains(Expectedship1),
				"Actual error message does not contain expected. \nActual: " + actualship1 + "\nExpected: "
						+ Expectedship1);
		
		//orderPrice
		WebElement orderPrice1 = driver.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[1]/td[@class='col total']/span[@class='price']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Expectedprice1 = "$246.00";
		String actualprice1 = orderPrice1.getText();
		System.out.println("price " + actualprice1);
		Assert.assertTrue(actualprice1.contains(Expectedprice1),
				"Actual error message does not contain expected. \nActual: " + actualprice1 + "\nExpected: "
						+ Expectedprice1);
		
		//check status
		WebElement status1 = driver.findElement(By.xpath("/html//table[@id='my-orders-table']/tbody/tr[1]/td[@class='col status']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Expectedstatus1 = "Pending";
		String actualstatus1 = status1.getText();
		System.out.println("status " + actualstatus1);
		Assert.assertTrue(actualstatus1.contains(Expectedstatus1),
				"Actual error message does not contain expected. \nActual: " + actualstatus1 + "\nExpected: "
						+ Expectedstatus1);
		
		//link
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * WebElement link = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.
		 * xpath("//table[@id='my-orders-table']/tbody/tr[1]/td[6]/a[@href='https://magento.softwaretestingboard.com/sales/order/view/order_id/21187/']/span[.='View Order'"
		 * ))); link.click();
		 */
		
		
		//order 2
		WebElement order2 = driver
				.findElement(By.xpath("/html//table[@id='my-orders-table']/tbody/tr[2]/td[@class='col id']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ExpectedOrder2 = "000021119";
		String actualOrder2 = order2.getText();
		System.out.println("order " + actualOrder1);

		Assert.assertTrue(actualOrder2.contains(ExpectedOrder2),
				"Actual error message does not contain expected. \nActual: " + actualOrder2 + "\nExpected: "
						+ ExpectedOrder2);
		
		
		//price2
		WebElement orderPrice2 = driver.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[2]/td[@class='col total']/span[@class='price']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Expectedprice2 = "$1,722.00";
		String actualprice2 = orderPrice2.getText();
		System.out.println("price " + actualprice2);
		Assert.assertTrue(actualprice2.contains(Expectedprice2),
				"Actual error message does not contain expected. \nActual: " + actualprice2 + "\nExpected: "
						+ Expectedprice2);
		
		
		//close browser
		driver.quit();
		
		

		
		
	}

	}
