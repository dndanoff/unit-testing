package io.github.dndanoff.impediments;

import org.junit.Before;
import org.junit.Test;

public class PrivateMethodImpedimentTest {
	PrivateMethodImpediment objUnderTest;
	
	@Before
	public void setup() {
		objUnderTest = new PrivateMethodImpediment();
	}
	
	@Test
	public void sanity() {
		objUnderTest.validate(null);
	}
}
