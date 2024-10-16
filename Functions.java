package com.fna.PH_v1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Functions extends BasePage {
	
	public static final int DEFAULT_TIMEOUT = 30;
	
	public void searchATextAndSelectCustomer(WebElement txtInput) throws Throwable {
		try {
			txtInput.clear();
			txtInput.sendKeys("Four Middle Customer");
			Thread.sleep(3000);
			List<WebElement> RowCount = driver.findElements((By.xpath("//mat-table//mat-row")));
			for (int i = 0; i <= RowCount.size(); i++) {
				String s = RowCount.get(i).getText();
				String[] s1 = s.split("\n");
				String s2 = s1[0].toString();
				if (s2.equals("Four Middle Customer")) {
					//String s3 = s2.concat(" ");
					WebElement sd = driver.findElement(By.xpath("//*[text()=\'" + s2 + "']//ancestor::mat-cell"));
					sd.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginPage(WebElement LoginTxtUsername, WebElement LoginTxtPass, WebElement LoginBtn, String user, String pass) {
		int RETRY = 10;
		int i = 0;
		do {
			i++;
			try {
				Thread.sleep(1000);
				if (LoginTxtUsername.isDisplayed()) {
					LoginTxtUsername.clear();
					LoginTxtUsername.click();
					LoginTxtUsername.sendKeys(user);
				}
				if (LoginTxtPass.isDisplayed()) {
					LoginTxtPass.clear();
					LoginTxtPass.click();
					LoginTxtPass.sendKeys(pass);
				}
				if (LoginBtn.isDisplayed()) {
					Thread.sleep(DEFAULT_TIMEOUT);
					LoginBtn.click();
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (i < RETRY);
	}
	
	public static void highLightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}
	
	public static void clickOnElement(String xpath) throws Exception {
		int i = 0;
		do {
			try {
				driver.findElement(By.xpath(xpath)).click();
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Attempting to click the element");
				i += 1;
				Thread.sleep(1000);
			}
		} while (i < DEFAULT_TIMEOUT);
	}
	
	public static void clickUsingActions(WebElement elem) throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(elem).click(elem);
		builder.perform();
	}
	
	public void changeLanguage() throws Exception {
		clickOnElement("//cpos-vn-left-setting-item[7]//div[2]");
		Thread.sleep(500);
		clickOnElement("//*[@id=\"mat-tab-label-1-1\"]");
		clickOnElement("//div/mat-chip[2]");
		clickOnElement("//cpos-vn-left-setting-item[1]/div");
		Thread.sleep(DEFAULT_TIMEOUT);
	}
	
	public static void waitUntilPageLoadingCompleted() throws Exception {
		Thread.sleep(2000);
		String xpath = "cpos-spinner";
		int i = 0;
		do {
			try {
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					i++;
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				i++;
				Thread.sleep(100);
			}
		} while (i < DEFAULT_TIMEOUT);
	}
}
