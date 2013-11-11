package br.org.cesar.common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.org.cesar.util.MyRemoteWebDriver;


/**
 * Classe Utils para o Selenium
 * Ela esta implementando a classe 'SeleniumInterface' para utilizar o nome dos browsers
 * 
 *
 */
public class Selenium {
	
	private static ChromeDriverService service = null;
	private static WebDriver driver = null;
	
	
	
	public static WebDriver getDriver() {
		String browser = Property.BROWSER_NAME;
		if (driver == null) {
			if (Browser.CHROME.equals(browser)) {
				service = new ChromeDriverService.Builder()
			        .usingDriverExecutable(new File(Property.CHROME_DRIVE_PATH))
			        .usingAnyFreePort()
			        .build();
			    try {
					service.start();
//					driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
					driver = new MyRemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
				} catch (IOException e) {
					driver = null;
				}
			} else if (Browser.IE.equals(browser)) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				File file = new File(Property.IE64_DRIVE_PATH);
				
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
			}else  if (Browser.FIREFOX.equals(browser)){
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public static void resetDriver(){
		driver = null;
		String browser = Property.BROWSER_NAME;
		if (service != null && Browser.CHROME.equals(browser)) {
			service.stop();
		}
	}
}
