package io.github.dndanoff.rules;

import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class VerifierRuleTest {
	private String errorMsg = null;
	
	@Rule
	public Verifier rule = new Verifier() {
		protected void verify() {
			assertNull("ErrorMsg should be null after each test execution", errorMsg);
		}
	};

	@Test
	public void testName() throws Exception {
		errorMsg = "Giving a value";
	}
}
