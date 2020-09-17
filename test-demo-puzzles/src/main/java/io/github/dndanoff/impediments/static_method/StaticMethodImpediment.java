package io.github.dndanoff.impediments.static_method;

public class StaticMethodImpediment {
	
	private final DependencyWithStaticMethod dep;
	
	public StaticMethodImpediment(DependencyWithStaticMethod dep) {
		this.dep = dep;
	}
	
	public void testMe() {
		DependencyWithStaticMethod.staticMethodImpediment();
	}
	
	public static void staticMethodImpediment() {
		throw new IllegalStateException();
	}
}
