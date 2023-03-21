/*
 * package com.softwaretesting.magneto;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Assert;
 * import org.testng.annotations.Test;
 * 
 * 
 * public class order{
 * 
 * @Test public class orderCreate {
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "src/main/resources/chromedriver"); WebDriver driver = new ChromeDriver();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //
 * maximize driver.manage().window().maximize(); // open login page String url =
 * "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
 * driver.get(url); System.out.println("page is open"); // login // enter name
 * WebElement username = driver.findElement(By.id("email"));
 * username.sendKeys("jimK@yaho.com");
 * 
 * // enter password WebElement password = driver.findElement(By.id("pass"));
 * password.sendKeys("timKhan@123");
 * 
 * // click button WebElement logInButton = driver.findElement(By.id("send2"));
 * logInButton.click();
 * 
 * // navigate to other url String urlBag =
 * "https://magento.softwaretestingboard.com/gear/bags.html";
 * driver.get(urlBag);
 * 
 * // select bag WebElement bag = driver.findElement(By.xpath(
 * "//main[@id='maincontent']//div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/push-it-messenger-bag.html']/span[@class='product-image-container']//img[@alt='Push It Messenger Bag']"
 * )); bag.click();
 * 
 * // add to cart WebElement addCartBtn =
 * driver.findElement(By.id("product-addtocart-button")); addCartBtn.click();
 * 
 * // explicit wait WebDriverWait wait = new WebDriverWait(driver,
 * Duration.ofSeconds(10)); WebElement msg = wait.until(ExpectedConditions
 * .visibilityOfElementLocated(By.xpath(
 * "//main[@id='maincontent']//div[@role='alert']/div"))); String Actualmsg =
 * msg.getText(); String expectedmsg =
 * "You added Push It Messenger Bag to your shopping cart.";
 * Assert.assertTrue(Actualmsg.contains(expectedmsg),
 * "Actual error message does not contain expected. \nActual: " + Actualmsg +
 * "\nExpected: " + expectedmsg);
 * 
 * 
 * //navigate to add to cart page String cartPage =
 * "https://magento.softwaretestingboard.com/checkout/#shipping";
 * driver.get(cartPage);
 * 
 * } } }
 */