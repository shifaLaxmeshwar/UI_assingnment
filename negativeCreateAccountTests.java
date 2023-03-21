package com.softwaretesting.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class negativeCreateAccountTests {
	@Test(enabled = false,priority =1 )
	public void reregisteredAccountTest() {
		System.out.println("Creating new account with registered mail ");
		WebDriver driver = browser();
		//open test page
		String  url = "https://magento.softwaretestingboard.com/customer/account/create/";
		driver.get(url);
		System.out.println("opening create account page");
		//enter first name
		 WebElement firstname = driver.findElement(By.id("firstname"));
		 firstname.sendKeys("jim");
		//enter last name
		 WebElement lastname = driver.findElement(By.id("lastname"));
		 lastname.sendKeys("k");
		//enter registered email 
		 WebElement getEmail = driver.findElement(By.id("email_address"));
		 getEmail.sendKeys("jimK@yaho.com");
		//enter password
		 WebElement password = driver.findElement(By.id("password"));
		 password.sendKeys("timKhan@123");
		//enter the same password
		 WebElement currentPassword = driver.findElement(By.id("password-confirmation"));
		currentPassword.sendKeys("timKhan@123");
		//click on create new account btn
		WebElement accBtn = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
		accBtn.click();
		sleep(2000);
		//verify error msg
		WebElement errorMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div")); 
		String expectedErrorMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
	    String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual: " 
						+ actualErrorMessage + "\nExpected: "
						+ expectedErrorMessage);
		//close browser
		driver.quit();
	}

	@Test(enabled=false , priority= 2 )
	
	public void nonIdenticalPasswords() {
		System.out.println("Creating new account with non identical passwords ");
		WebDriver driver = browser();
		//open test page
		String  url = "https://magento.softwaretestingboard.com/customer/account/create/";
		driver.get(url);
		//enter first name
		 WebElement firstname = driver.findElement(By.id("firstname"));
		 firstname.sendKeys("reena");
		//enter last name
		 WebElement lastname = driver.findElement(By.id("lastname"));
		 lastname.sendKeys("kaur");
		//enter email 
		 WebElement getEmail = driver.findElement(By.id("email_address"));
		 getEmail.sendKeys("renna@yaho.com");
		//enter password
		 WebElement password = driver.findElement(By.id("password"));
		 password.sendKeys("Reena@123");
		//enter the same password
		 WebElement currentPassword = driver.findElement(By.id("password-confirmation"));
		currentPassword.sendKeys("Kaur@123");
		//click on create new account btn
				WebElement accBtn = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
				accBtn.click();
				sleep(2000);
				//verify error msg
				
				 // WebElement confirmPasswordMessage =
				  //driver.findElement(By.xpath("/html//div[@id='password-confirmation-error']"));
				   //String expectedErrorMessage = "Please enter the same value again."; 
				   //String actualErrorMessage = confirmPasswordMessage.getText();
				  //Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				  //"Actual error message does not contain expected. \nActual: " +
				  //actualErrorMessage + "\nExpected: " + expectedErrorMessage);
				 
				  
				  WebElement confirmPasswordMessage =
						  driver.findElement(By.xpath("//div[@role='alert']"));
				  String errormsg="Please make sure your passwords match.";
				  String expectederror = confirmPasswordMessage.getText();
				Assert.assertTrue(errormsg.contains(expectederror),
				  "Actual error message does not contain expected. \nActual: " +
						  errormsg + "\nExpected: " + expectederror);
				//
				//close browser
				driver.quit();
	}
	@Test(enabled=true, priority = 3)
	public void passwordLengthTest() {
		System.out.println("Starting test for passowords having very small lenght even though they are identical");
		WebDriver driver = browser();
		//open test page
				String  url = "https://magento.softwaretestingboard.com/customer/account/create/";
				driver.get(url);
				//enter first name
				 WebElement firstname = driver.findElement(By.id("firstname"));
				 firstname.sendKeys("reena");
				//enter last name
				 WebElement lastname = driver.findElement(By.id("lastname"));
				 lastname.sendKeys("kaur");
				//enter email 
				 WebElement getEmail = driver.findElement(By.id("email_address"));
				 getEmail.sendKeys("renna@yaho.com");
				//enter password
				 WebElement password = driver.findElement(By.id("password"));
				 password.sendKeys("Reena");
				//enter the same password
				 WebElement currentPassword = driver.findElement(By.id("password-confirmation"));
				currentPassword.sendKeys("Reena");
				//click on create new account btn
						WebElement accBtn = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
						accBtn.click();
						sleep(2000);
			   //verify error msg
						
						  WebElement warningMsg =
						  driver.findElement(By.xpath("//div[@role='alert']"));
						   String expectedErrorMessage = "The password needs at least 8 characters. Create a new password and try again."; 
						   String actualErrorMessage = warningMsg.getText();
						  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
						  "Actual error message does not contain expected. \nActual: " +
						  actualErrorMessage + "\nExpected: " + expectedErrorMessage);		
				//	close browser
						  driver.quit();
	}
	private WebDriver browser() {
		//create driver
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		return driver;
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