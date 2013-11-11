package br.org.cesar.test;

import org.junit.Test;

import br.org.cesar.common.HomePage;


public class HomePageValidation extends BaseTestcase{
	/**
	 * Example app is CESAR's EDU website
	 * Tests for operations related with the home screen, like:
	 * clicking a course
	 */


	/**
	 *  Click Extensão Link and click selenium course
	 */
	@Test
	public void clickLinkToSeleniumCourse() {
		HomePage.clickLinkExtensao();
		HomePage.clickLinkCursoSelenium();
		HomePage.isPageSubTitleCorrect();
	}
	
}
