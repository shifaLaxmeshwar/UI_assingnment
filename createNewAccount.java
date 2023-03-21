package com.softwaretesting.magneto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createNewAccount {
	

	@Test
	public void simpleAccountCreation() {
		System.out.println("Starting the account creation process");
		//create driver
	 	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		 WebDriver driver = new ChromeDriver();
		
		 ChromeOptions options = new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");
		//WebDriverManager.chromedriver().setup();
		
		//max test window
		 driver.manage().window().maximize();
		//open test page
		 //String url = "www.google.com";
		 
		//open the test page
			String url = "https://magento.softwaretestingboard.com/customer/account/create/";
			driver.get(url);
			
		 //driver.get(url);
		 sleep(1000);
		//enter first name
		 WebElement firstname = driver.findElement(By.id("firstname"));
		 firstname.sendKeys("yaani");
		//enter last name
		 WebElement lastname = driver.findElement(By.id("lastname"));
		 lastname.sendKeys("kappor");
		//Enter email
		 WebElement getEmail = driver.findElement(By.id("email_address"));
		 getEmail.sendKeys("yaaniK@yaho.com");
		//Enter password
		 WebElement password = driver.findElement(By.id("password"));
		 password.sendKeys("timKhan@123");
		 
		//enter the same password
		 WebElement currentPassword = driver.findElement(By.id("password-confirmation"));
		currentPassword.sendKeys("timKhan@123");
		//verify password
		//Assert.assertEquals( password,  currentPassword,"no matching passwords");

		//click on create an account
			WebElement accBtn = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
			accBtn.click();
		//verify new url
		String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
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

