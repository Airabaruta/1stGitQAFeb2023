package homework01;

//Scenario: Users will be able to add Account
//1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
//2. Enter username: demo@techfios.com 
//3. Enter password: abc123
//4. Click login button
//5. Click on Bank & Cash button
//6. Click on New Account button 
//7. Fill out the Add New Account form
//8. Click on submit button
//9. Visually check if the account has been created


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session1 {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"account\"]")).sendKeys("AngelMiAccount");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("Checking");
		driver.findElement(By.xpath("//*[@id=\"balance\"]")).sendKeys("500000");
		driver.findElement(By.xpath("//*[@id=\"account_number\"]")).sendKeys("123456799");
		driver.findElement(By.xpath("//*[@id=\"contact_person\"]")).sendKeys("Angel Irabaruta");
		driver.findElement(By.xpath("//*[@id=\"contact_phone\"]")).sendKeys("3254507880");
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).click();

	}

	@After
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
