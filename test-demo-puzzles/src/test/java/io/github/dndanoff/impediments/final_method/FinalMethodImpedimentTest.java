package io.github.dndanoff.impediments.final_method;

import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FinalMethodImpedimentTest {
	
	@Mock
	private DependencyWithFinalMethod dep;
	
	private FinalMethodImpediment objUnderTest = new FinalMethodImpediment(dep);
	
	@Test
	public void sanity() {
		doNothing().when(dep).finalMethodImpediment();
		objUnderTest.testMe();
	}
}
