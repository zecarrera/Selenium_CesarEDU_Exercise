package br.org.cesar.test;

import org.junit.Test;

import br.org.cesar.common.CesarEDU;
import br.org.cesar.test.BaseTestcase;
//import br.org.cesar.common.HomePage;


public class CesarEDUValidation extends BaseTestcase{


	/**
	 *  2. Acesse o link da extens�o de testes com selenium

        3. Verifique se a p�gina correta foi carregada
	 */
	@Test
	public void assertHomeScreenTitle() {
		CesarEDU.clickLinkDaExtensao();
		CesarEDU.assertTitle("CESAR EDU - Automa��o de Testes para Web com Selenium");	
	}
	
	

}

