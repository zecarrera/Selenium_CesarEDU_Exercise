package br.org.cesar.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.org.cesar.test.HomePageValidation;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
		HomePageValidation.class
	})

public class AllTests {

}
