package com.fna.PH_v1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import DataProvider.da_Precondition;
import pageLocator.loginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login2CustomerList extends BasePage {
	
	loginPage lgpage = null;
	public static final int DEFAULT_TIMEOUT = 30;
	public Functions fc = new Functions();
	public int i = 0;
	
	public Login2CustomerList() {
		this.lgpage = new loginPage();
		PageFactory.initElements(BasePage.getDriver(), lgpage);
	}
	
	@BeforeTest
	public void setup() {
		openURL();
	}

	@Test(dataProvider = "data_Login", dataProviderClass = da_Precondition.class)
	public void test(String user, String pass) throws Throwable {
		WebElement LoginTxtUsername = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement LoginTxtPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LoginBtnLogin = driver.findElement(By.xpath("//*[@id=\"login__form\"]/div[4]/button"));
		fc.loginPage(LoginTxtUsername,LoginTxtPassword,LoginBtnLogin, user, pass);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/cpos-custom-dialog/div/div[3]/button"));
		if (closeButton.isDisplayed()) {
			Thread.sleep(1000);
			closeButton.click();
			Thread.sleep(1000);
			fc.changeLanguage();
			WebElement searchField = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
			fc.searchATextAndSelectCustomer(searchField);
			Thread.sleep(2000);
			WebElement fnaCard = driver.findElement(By.xpath("//div[contains(text(),' needs')]"));
			fnaCard.click();
			Thread.sleep(1000);
			}
	}

	@AfterTest
	public void afterTest() throws Exception {
		//final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
			driver.quit();
		}

}
