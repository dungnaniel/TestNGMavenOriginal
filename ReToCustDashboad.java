package com.fna.PH_v1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class ReToCustDashboad extends BasePage {

	public static final int DEFAULT_TIMEOUT = 30;
	public Functions fc = new Functions();
	
  @Test
  public void f() throws Throwable {
	 WebElement searchField = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
	fc.searchATextAndSelectCustomer(searchField);
  }
  
  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
