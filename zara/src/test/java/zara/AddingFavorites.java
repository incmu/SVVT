package svvt.lab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class AddingFavorites {

	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/nox/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-blink-features=AutomationControleld");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		baseUrl="https://www.zara.com/ba/en/";
		webDriver = new ChromeDriver(options);
		
		
		
		 //PROVJERI JEL IZBACENO IZ FAVORITEA PRIJE TESTA
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/button")).click();
		Thread.sleep(3000); // cookies
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(3000); //log-in
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[1]/div[1]/div/div/div[1]/input")).sendKeys("kenan.p996@gmail.com");
		Thread.sleep(2000); //unos mejla
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[1]/div[2]/div/div/div[1]/div/input")).sendKeys("5VyRtFejkZzuKQG");
		Thread.sleep(2000); // unos passworda
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[2]/button")).click();
		Thread.sleep(3000); // sign-in
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		Thread.sleep(3000); // menu
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[2]/a")).click();
		Thread.sleep(3000); // man
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[2]/ul/li[6]/a")).click();
		Thread.sleep(3000); // jackets
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[1]/div[2]/div/a[1]")).click();
		Thread.sleep(3000); // klikne na drugu sliku
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[1]/div[1]/button")).click();
		Thread.sleep(3000); // favorites
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[3]")).click();
		Thread.sleep(3000); //  korpa
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/div[1]/nav/div/div/ul/li[2]/a")).click();
		Thread.sleep(3000); // favorites
		String fav = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/ul/li/div[2]/div[1]/div[1]/a/span")).getText();
		assertTrue(fav.contains("JACKET - LIMITED EDITIONN"));
		Thread.sleep(3000);
	}

	

}
