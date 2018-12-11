package cjwsjy.pqmstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class pqms_test_demo {

	WebDriver driver;

	@BeforeClass
	public void beforeTest() {
		/*
		 * firefox作为浏览器启动 System.setProperty("webdriver.gecko.driver",
		 * "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
		 */
		// chrome作为浏览器启动
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

		// driver = new FirefoxDriver();
		driver = new ChromeDriver();

		driver.get("http://10.6.172.179:8080/pqms/pqms/page_login.html");
	}

	@Parameters("browser")
	// @BeforeMethod
	public void setupBrowser(String browser) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@Test
	public void commitkeyword() {

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("admin");

		username.submit();

		WebElement password = driver.findElement(By.id("password"));

		password.sendKeys("123456");

		password.submit();

		WebElement button = driver.findElement(By.id("btn"));

		button.click();
	}

	@AfterClass
	public void closed() {
		// 关闭浏览器
		driver.quit();
		System.out.println("关闭浏览器成功");
	}

}
