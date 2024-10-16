package com.fna.PH_v1;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static WebDriver driver;
	private final Duration shortWait = Duration.ofSeconds(10);

	public static void openURL() {
		try {
			String path = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
					+ "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://sea-emm-sit-api.ap.manulife.com/int/pos-web-vn-app/");
			driver.navigate().refresh();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public void ClickElement(By locator) {
		new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement FindElement(By locator) {
		return new WebDriverWait(driver, shortWait).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
