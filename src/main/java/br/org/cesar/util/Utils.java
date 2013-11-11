package br.org.cesar.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.common.Selenium;

public abstract class Utils {	
	
	private static final WebDriver driver;
	private static final WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public static void isVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void isVisible(String id) {
		isVisible(By.id(id));
	}
	
	public static void isLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void isLocated(String id) {
		isLocated(By.id(id));
	}
	
	public static void isClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void isClickable(String id) {
		isClickable(By.id(id));
	}
	
	
	public static void takeScreenshot(String fileName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
	    try {
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumScreenShots\\"+fileName+'-'+date.getTime()+".jpeg"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Deprecated
	public static ExpectedCondition<Boolean> isCssClass(
			final By locator, final String propertyName) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return propertyName.equals(driver.findElement(locator).getAttribute("class"));
			}
		};
	}
		
	@Deprecated
	public static String generateString(int length) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = length; i > 0; i -= 12) {
	      int n = Math.min(12, Math.abs(i));
	      sb.append(StringUtils.leftPad(Long.toString(Math.round(Math.random() * Math.pow(36, n)), 36), n, '0'));
	    }
	    return sb.toString();
	}

//	@Deprecated
//	public static void defaultWait() {
//		wait(1000);
//	}

	
	
	/**
	 * Pause for X milliseconds.
	 * 
	 * @param iTimeInMillis
	 */
	@Deprecated
	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
