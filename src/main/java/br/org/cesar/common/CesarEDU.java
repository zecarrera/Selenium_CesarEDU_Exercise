package br.org.cesar.common;


import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.common.Selenium;
import br.org.cesar.util.Utils;


public class CesarEDU {

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
	
	// Acesse o link da extensão de testes com selenium 
    
	static By LinkDaExtensao = By.id("cs-slider24");
    
	public CesarEDU() {
	}

	/**
	 * Checks if page title is the one expected
	 * @param texto
	 */
	public static void clickLinkDaExtensao(){
		Utils.isVisible(LinkDaExtensao);
		driver.findElement(LinkDaExtensao).click();
	}	
	
	/**
	 * Checks if page title is the one expected
	 * @param texto
	 */
	public static void assertTitle(String texto){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
		String title = driver.getTitle();
		Assert.assertEquals(texto, title);
	}
	

}