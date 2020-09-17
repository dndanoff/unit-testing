package io.github.dndanoff.impediments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VariableInitializationProblemTest {
	
	@Mock
	VariableInitializationProblem.BadDependency dep;
	
	private VariableInitializationProblem objectUnderTest = new VariableInitializationProblem() {
		BadDependency createDependency() {
			return dep;
		};
	};
	
	@Test
	public void sanity() {
	
	}
}
