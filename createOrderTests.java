package com.softwaretesting.magneto;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class createOrderTests {
	private WebDriver driver;
	@Test
	public void order() throws InterruptedException {
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

		// navigate to other url
		String urlBag = "https://magento.softwaretestingboard.com/gear/bags.html";
		driver.get(urlBag);

		// select bag
		WebElement bag = driver.findElement(By.xpath(
				"//main[@id='maincontent']//div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/push-it-messenger-bag.html']/span[@class='product-image-container']//img[@alt='Push It Messenger Bag']"));
		bag.click();

		// add to cart
		WebElement addCartBtn = driver.findElement(By.id("product-addtocart-button"));
		addCartBtn.click();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement msg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//main[@id='maincontent']//div[@role='alert']/div")));
		String Actualmsg = msg.getText();
		String expectedmsg = "You added Push It Messenger Bag to your shopping cart.";
		Assert.assertTrue(Actualmsg.contains(expectedmsg), "Actual error message does not contain expected. \nActual: "
				+ Actualmsg + "\nExpected: " + expectedmsg);
		
		
		//navigate to add to cart page
		String cartPage = "https://magento.softwaretestingboard.com/checkout/#shipping";
		driver.get(cartPage);
		
		//explicit wait
		
		  WebDriverWait hold = new WebDriverWait(driver, Duration.ofSeconds(20));
		  WebElement Btn = hold.until(ExpectedConditions
		  .elementToBeClickable(By.xpath(
		  "//div[@id='shipping-method-buttons-container']/div/button")));
		 
		  
		/*
		 * Thread.sleep(1000); Btn.click();
		 * 
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(15));
		 * WebElement Btn2 = driver.findElement(By.xpath(
		 * "//div[@id='shipping-method-buttons-container']/div/button"));
		 * wait1.until(ExpectedConditions.elementToBeClickable(Btn)); Btn2.click();
		 */
		 
	    
		
		/*
		 * 
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); WebElement
		 * Btn4 = driver.findElement(By.
		 * xpath("//button[@class='button action continue primary']"));
		 * wait1.until(ExpectedConditions.elementToBeClickable(Btn4)); Btn.click();
		 * sleep(2000);
		 */
	    
		/*
		 * WebElement box =
		 * driver.findElement(By.xpath(
		 * "/html//input[@id='billing-address-same-as-shipping-checkmo']"));
		 * Assert.assertEquals(true, radioBtn.isSelected());
		 * 
		 * WebElement placeBtn =
		 * driver.findElement(By.xpath("//button[@class='action primary checkout']"));
		 * waits.until(ExpectedConditions.elementToBeClickable(placeBtn));
		 */
		 //confirmation
			/*
			 * WebElement orderConfirm = driver.findElement(By.xpath(
			 * "/html//main[@id='maincontent']//div[@class='checkout-success']/p[1]"));
			 * String Amsg = msg.getText(); String Emsg =
			 * "Your order number is: 000021188."; Assert.assertTrue(Amsg.contains(Emsg),
			 * "Actual error message does not contain expected. \nActual: " + Actualmsg +
			 * "\nExpected: " + expectedmsg);
			 */
		
		 
	  //span[text(🙁'Next']
		

		/*
		 * WebElement company =
		 * driver.findElement(By.xpath("//input[@name='company']"));
		 * company.sendKeys("Nextuple");
		 * 
		 *  WebElement street =
		 * driver.findElement(By.xpath("//input[@name='street[0]']"));
		 * street.sendKeys("abcdefg");
		 * 
		 * WebElement city =
		 * driver.findElement(By.xpath("//input[@name='city']"));
		 * city.sendKeys("hubalii");
		 */
	    	 
	    	 
				/*
				 * //country Select country = new
				 * Select(driver.findElement(By.name("country_id")));
				 * country.selectByVisibleText("India");
				 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name(
				 * "country_id")));
				 */
	    	 
	    	 //region
				/*
				 * Select state = new Select(driver.findElement(By.name("region_id")));
				 * state.selectByVisibleText("Karnataka"); WebDriverWait wait6 = new
				 * WebDriverWait(driver,Duration.ofSeconds(15));
				 * 
				 */
	    	 
	    	 //postcode
				/*
				 * WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(15));
				 * WebElement zipcode =
				 * driver.findElement(By.xpath("//input[@name='postcode']"));
				 * zipcode.sendKeys("580000");
				 */
			  
			 //phone
				/*
				 * WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(15));
				 * WebElement phone= driver.findElement(By.
				 * xpath("//div[@class='control _with-tooltip']//input[@class='input-text']"));
				 * phone.sendKeys("9876543210");
				 */
	    	 
	    
	    	//assertion for check box
			
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); WebElement
			  radioBtn = driver.findElement(By.xpath("//input[@name='ko_unique_1']"));
			  radioBtn.click();
			  Assert.assertEquals(true, radioBtn.isSelected());
			 
			  	 
	    	 //nextbtn

		  WebElement nextBtn =  driver.findElement(By.xpath("//div[@id=\"checkout-step-shipping_method\"]/form/div[@class=\"actions-toolbar\"]/div/button")); 
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Actions action1 = new Actions(driver);
          action1.moveToElement(nextBtn).click().build().perform();

	    	 //placebtn
	    	 
	  WebElement placeBtn = driver.findElement(By.xpath("//div[@class='payment-method _active']/div[2]/div[@class=\"actions-toolbar\"]/div[@class=\"primary\"]/button")); 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Actions action2 = new Actions(driver);
             action2.moveToElement(placeBtn).click().build().perform();
             
             
             
             
             //order number
             String order_no = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
             driver.get(order_no);
             sleep(2000);
             
             //
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
             WebElement proceed = driver.findElement(By.xpath("/html//main[@id='maincontent']//div[@class='cart-summary']/ul//button[@title='Proceed to Checkout']"));
             proceed.click();
        
             
             WebElement number=driver.findElement(By.xpath("//a[@class='order-number']"));
            String expect =  number.getText();
            String real = " 000001437";
            Assert.assertEquals(real, expect, "Actual page url is not the same as expected");
    		

		// close browser
	    	driver.quit(); 

	}
	/*
	 * @AfterMethod(alwaysRun = true) private void TearDown() throws
	 * InterruptedException {
	 * 
	 * driver.quit(); }
	 */
//
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}