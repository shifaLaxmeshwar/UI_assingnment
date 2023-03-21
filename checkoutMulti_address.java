package com.softwaretesting.magneto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkoutMulti_address {

	
@Test
	public void addTocart() {

		// Create Web driver
	System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");	
	WebDriver driver = new ChromeDriver();
		
		// maximize browser window
		driver.manage().window().maximize();

		// open the login page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/";
		driver.get(url);

		// enter user email
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("roop@gmail.com");
		sleep(1000);

		// enter the password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("AsdF!23$5");

		// Click on sign in button
		WebElement SignIn_button = driver.findElement(By.xpath(
				"/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
		SignIn_button.click();

		// Verifying url
		String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Actual Url is not same as the expected url");
		sleep(1000);

		// open the test page
		driver.get(
				"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_mode=list");

		// click on learn more link on a particular product
		WebElement link = driver.findElement(By.xpath(
				"/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[2]/div[@class='product-item-info']//a[@title='Juno Jacket']"));
	    link.click();
		sleep(1000);
		
		String Expected_Url = "https://magento.softwaretestingboard.com/juno-jacket.html";
		String Actual_Url= driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url, "Actual Url is not same as the expected url");
		sleep(1000);

		WebElement size = driver.findElement(By.id("option-label-size-143-item-168"));
		size.click();

		WebElement color = driver.findElement(By.xpath(
				"//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[2]/div[@role='listbox']/div[3]"));
		color.click();


		WebElement clickButtonAdd = driver
				.findElement(By.xpath("//button[@id='product-addtocart-button']/span[.='Add to Cart']"));
		clickButtonAdd.click();
		sleep(1000);


	
		driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
		
		//click on checkout with multiple address
		WebElement mult_address= driver.findElement(By.xpath("//main[@id='maincontent']//div[@class='cart-summary']/ul//a[@href='https://magento.softwaretestingboard.com/multishipping/checkout/']/span[.='Check Out with Multiple Addresses']"));
		mult_address.click();
		sleep(1000);
		
		//expected page
		String ExpectedUrl4 = "https://magento.softwaretestingboard.com/multishipping/checkout/addresses/";
		String ActualUrl4 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl4, ExpectedUrl4, "Actual Url is not same as the expected url");
		sleep(2000);
		
		//click on New Address button
		WebElement New_Address_btn= driver.findElement(By.xpath("//form[@id='checkout_multishipping_form']//button[@title='Enter a New Address']/span[.='Enter a New Address']"));
		New_Address_btn.click();
		sleep(1000);
		
		//expected page
		String ExpectedUrl5 = "https://magento.softwaretestingboard.com/multishipping/checkout_address/newShipping/";
		String ActualUrl5 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl5, ExpectedUrl5, "Actual Url is not same as the expected url");
		sleep(2000);
		
		
//		//enter company 
//		WebElement company = driver.findElement(By.xpath("/html//input[@id='company']"));
//		company.sendKeys("xyz");
//  	sleep(2000);
//		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='company']")));
		
		//enter phone number
		WebElement phone_no= driver.findElement(By.xpath("/html//input[@id='telephone']"));
		phone_no.sendKeys("9876543201");
		WebDriverWait wait_1= new WebDriverWait(driver,Duration.ofSeconds(30));
		wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='telephone']")));
		
		//enter street address
		WebElement street= driver.findElement(By.xpath("/html//form[@id='form-validate']/fieldset[2]/div[1]/div[@class='control']/input[@name='street[]']"));
		street.sendKeys("Rajajinagar");
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//form[@id='form-validate']/fieldset[2]/div[1]/div[@class='control']/input[@name='street[]']")));
		
		//enter city
		WebElement city= driver.findElement(By.xpath("/html//input[@id='city']"));
		city.sendKeys("Banglore");
		sleep(3000);
		
		//country dropdown
		Select dropCountry = new Select (driver.findElement(By.name("country_id")));
		dropCountry.selectByVisibleText("India");
		sleep(3000);
		
		//state dropdown
		Select dropState= new Select (driver.findElement(By.name("region_id")));
		dropState.selectByVisibleText("Karnataka");
		sleep(3000);
		
		//postal code
		WebElement postal_code= driver.findElement(By.xpath("/html//input[@name='postcode']"));
		postal_code.sendKeys("560010");
		sleep(3000);
		
		//check out box
		WebElement default_billing_address = driver.findElement(By.id("primary_shipping"));
		default_billing_address.click();
		sleep(1000);
		
		//click on save button
		WebElement save= driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Save Address']/span[.='Save Address']"));
		save.click();
		sleep(3000);
		
		//url page
		String ExpectedUrl6 = "https://magento.softwaretestingboard.com/multishipping/checkout/addresses/";
		String ActualUrl6 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl6, ExpectedUrl6, "Actual Url is not same as the expected url");
		sleep(2000);
		
		//success message
		WebElement successmessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div[.='You saved the address.']"));
		String expectedMessage = "You saved the address.";
		String actualMessage = successmessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);
		sleep(1000);
		
		//click on go to shipping information
		WebElement shipping_info= driver.findElement(By.xpath("//form[@id='checkout_multishipping_form']//button[@title='Go to Shipping Information']/span[.='Go to Shipping Information']"));
		shipping_info.click();
		sleep(3000);
		
		//expected page
		String ExpectedUrl7 = "https://magento.softwaretestingboard.com/multishipping/checkout/shipping/";
		String ActualUrl7 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl7, ExpectedUrl7, "Actual Url is not same as the expected url");
		sleep(2000);
		
		//click on goto Shipping Information button
		WebElement billing_inf_btn= driver.findElement(By.xpath("//form[@id='shipping_method_form']//button[@type='submit']/span[.='Continue to Billing Information']"));
		billing_inf_btn.click();
		sleep(2000);
				
				//expected page
				String ExpectedUrl9 = "https://magento.softwaretestingboard.com/multishipping/checkout/billing/";
				String ActualUrl9= driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl9, ExpectedUrl9, "Actual Url is not same as the expected url");
				sleep(2000);
			
				//click on Go to Review your order button
				WebElement review_btn = driver.findElement(By.xpath("//button[@id='payment-continue']/span[.='Go to Review Your Order']"));
				review_btn.click();
				sleep(2000);
				
				//expected page
				String ExpectedUrl10 = "https://magento.softwaretestingboard.com/multishipping/checkout/overview/";
				String ActualUrl10 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl10, ExpectedUrl10, "Actual Url is not same as the expected url");
				sleep(2000);
				
			
				//click on Go to Place order button
				WebElement placeOrder= driver.findElement(By.xpath("//button[@id='review-button']/span[.='Place Order']"));
				placeOrder.click();
				sleep(2000);
			
				//expected page
				String ExpectedUrl11 = "https://magento.softwaretestingboard.com/multishipping/checkout/success/";
				String ActualUrl11 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl11, ExpectedUrl11, "Actual Url is not same as the expected url");
				sleep(1000);
				
				//success message
				WebElement successmessage1 = driver.findElement(By.xpath("/html//main[@id='maincontent']//span[.='Thank you for your purchase!']"));
				String expectedMessage1 = "Thank you for your purchase!";
				String actualMessage1 = successmessage1.getText();
				Assert.assertTrue(actualMessage1.contains(expectedMessage1),
						"Actual message does not contain expected message.\nActual Message: " + actualMessage1
								+ "\nExpected Message: " + expectedMessage1);
				sleep(1000);
				
				//continue shopping button
				WebElement continue_shop= driver.findElement(By.xpath("//div[@id='review-buttons-container']//button[@type='submit']/span[.='Continue Shopping']"));
				continue_shop.click();
				sleep(1000);
				
				//expected page 
				String ExpectedUrl12 = "https://magento.softwaretestingboard.com/";
				String ActualUrl12 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl10, ExpectedUrl10, "Actual Url is not same as the expected url");
				sleep(1000);
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

