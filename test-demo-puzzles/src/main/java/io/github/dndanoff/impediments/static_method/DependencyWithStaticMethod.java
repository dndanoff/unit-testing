package io.github.dndanoff.impediments.static_method;

public class DependencyWithStaticMethod{
	public static void staticMethodImpediment() {
		throw new IllegalStateException();
	}
}
