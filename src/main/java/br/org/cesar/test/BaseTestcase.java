package br.org.cesar.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;


import br.org.cesar.common.HomePage;
import br.org.cesar.common.Property;
import br.org.cesar.common.Selenium;
import br.org.cesar.util.TestRetry;

public class BaseTestcase {
	protected static HomePage homePage;
	protected static WebDriver driver;
	
	
//	@Rule
//	public TestRetry retry = new TestRetry(3);
	
	@BeforeClass
	public static void beforeClass() throws Exception {		
		driver = Selenium.getDriver();
		driver.navigate().to(Property.SITE_ADDRESS);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		driver.quit();
		Selenium.resetDriver();
	}
}
