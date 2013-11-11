package br.org.cesar.test;

import org.junit.Test;

import br.org.cesar.common.CesarEDU;
import br.org.cesar.test.BaseTestcase;
//import br.org.cesar.common.HomePage;


public class CesarEDUValidation extends BaseTestcase{


	/**
	 *  2. Acesse o link da extensão de testes com selenium

        3. Verifique se a página correta foi carregada
	 */
	@Test
	public void assertHomeScreenTitle() {
		CesarEDU.clickLinkDaExtensao();
		CesarEDU.assertTitle("CESAR EDU - Automação de Testes para Web com Selenium");	
	}
	
	

}

