package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;



/*
 * Executa todas as acoes na pagina Inicial
 */
public class HomePage {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	// The home page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
    static By extensaoLinkLocator = By.linkText("Extensão");
    static By cursoSeleniumLinkLocator = By.linkText("Automação de Testes para Web com Selenium");
    static By pageHeaderLocator = By.cssSelector("h3");
    
	public HomePage() {
	}

	/**
	 * Clicks link "Extensão"
	 */
	public static void clickLinkExtensao(){
		Utils.isClickable(extensaoLinkLocator);
		driver.findElement(extensaoLinkLocator).click();
	}	
	
	/**
	 * Clicks link for selenium course
	 */
	public static void clickLinkCursoSelenium() { 
		wait.until(ExpectedConditions.elementToBeClickable(cursoSeleniumLinkLocator));
		driver.findElement(cursoSeleniumLinkLocator).click();
	}
	
	
	
	/**
	 * Checks if page title is the one expected
	 */
	public static void isPageSubTitleCorrect(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeaderLocator));
		Assert.assertEquals("Automação de Testes para Web com Selenium", driver.findElement(pageHeaderLocator).getText());
	}
	
}