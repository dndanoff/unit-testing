package io.github.dndanoff.impediments.final_method;

public class FinalMethodImpediment {
	
	private final DependencyWithFinalMethod dep;
	
	public FinalMethodImpediment(DependencyWithFinalMethod dep) {
		this.dep = dep;
	}
	
	public void testMe() {
		dep.finalMethodImpediment();
	}
}
