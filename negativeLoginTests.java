package com.softwaretesting.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;


public class negativeLoginTests {
	@Test(enabled=false)
	//with correct captcha 
	public void incorrectEmail() throws IOException, InterruptedException, TesseractException {
		System.out.println("Starting test with incorrect email ");
		//create driver
	 	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//open test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("page is open");
		//enter incorrect mail
		WebElement username= driver.findElement(By.id("email"));
		username.sendKeys("xyz@mail.com");
		//enter password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("Shifa@mail");
		//click login
		WebElement logInButton = driver.findElement(By.id("send2"));
		logInButton.click();
		sleep(2000);
		
		//again enter mail and password 
		WebElement newMail = driver.findElement(By.xpath("/html//input[@id='email']"));
		newMail.sendKeys("Shifa@mail.com");
		WebElement newPasssword = driver.findElement(By.id("pass"));
		 newPasssword.sendKeys("Shifa@mail");
		//add dealy to manaully text captcha
	     
		 WebElement img = driver.findElement(By.xpath("//div[@id='captcha-container-user_login']//img[@alt='Please type the letters and numbers below']"));
		 File src =  img.getScreenshotAs(OutputType.FILE);
		 //store src in project directory
		 String path = "C:\\Users\\Shifa\\eclipse-workspace\\selenim-project-magneto\\captcha\\captchaimg.png";
		 //file handler 
		 FileHandler.copy(src, new File(path));
		 Thread.sleep(2000);
		 
		 //call itessaract
		 ITesseract image = new Tesseract();
		 //store the imgae text in str
		 String str = image.doOCR(new File(path));
		 System.out.println("image text  " + str);
	
		 WebElement cap = driver.findElement(By.xpath("/html//input[@id='captcha_user_login']"));
		 cap.sendKeys(str);
		 
		 
		 WebElement signButton = driver.findElement(By.id("send2"));
		 signButton.click();
		  
	  
	     
			/*
			 * //verify error message
			 * 
			 * WebElement errorMessage = driver.findElement(By.xpath(
			 * "//main[@id='maincontent']//div[@role='alert']/div/div")); String
			 * expectedErrorMessage = "Incorrect CAPTCHA"; String actualErrorMessage =
			 * errorMessage.getText();
			 * 
			 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
			 * "Actual error message does not contain expected. \nActual: " +
			 * actualErrorMessage + "\nExpected: " + expectedErrorMessage);
			 */
	     //click on sign in 
			/*
			 * WebElement signButton = driver.findElement(By.id("send2"));
			 * signButton.click();
			 * 
			 * //verify url String expectedUrl =
			 * "https://magento.softwaretestingboard.com/"; String actualUrl =
			 * driver.getCurrentUrl(); Assert.assertEquals(actualUrl, expectedUrl,
			 * "Actual page url is not the same as expected");
			 */
	  
	     
		//close browser
		driver.quit();
		System.out.println("page is close");
	}
	@Test(enabled = true)
	public void incorrectpassword() {
		System.out.println("Starting test with incorrect password ");
		//create driver
	 	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//open test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
		sleep(1000);
		System.out.println("page is open");
		
		//enter correct email
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Shifa@mail.com");
		
		//enter worng password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("123xyz");
		
		//click on sign in button
		WebElement logInButton = driver.findElement(By.id("send2"));
		logInButton.click();
		sleep(2000);
		//verify error msg
		WebElement errorMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		String actualErrorMessage = errorMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual: " 
						+ actualErrorMessage + "\nExpected: "
						+ expectedErrorMessage);
		
		//close browser
		driver.quit();
	}
	
	@Test(enabled = false)
	public void forgotPasswordTest()
	{
		System.out.println("Starting test for forgot password ");
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//open test page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
		driver.get(url);
		sleep(1000);
		System.out.println("page is open");
		
		//enter email or password
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Shifa@mail.com");
		//click on forgot password
		WebElement forgotbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//a[@href='https://magento.softwaretestingboard.com/customer/account/forgotpassword/']/span[.='Forgot Your Password?']"));
		forgotbutton.click();
		//verify url
		String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/forgotpassword/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		//update password
		//enter captcha
		
		
		//click on reset password
		//verify message
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