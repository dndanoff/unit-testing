package io.github.dndanoff.impediments.final_method;

public class DependencyWithFinalMethod{
	public final void finalMethodImpediment() {
		throw new IllegalStateException();
	}
}
