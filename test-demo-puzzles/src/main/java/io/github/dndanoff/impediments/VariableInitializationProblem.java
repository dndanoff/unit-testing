package io.github.dndanoff.impediments;

public class VariableInitializationProblem {
	
	private BadDependency dependency;
	
	public VariableInitializationProblem() {
		dependency = createDependency();
	}
	
	public void toBeTested() {
		
	}
	
	BadDependency createDependency() {
		return new BadDependency();
	}
	
	public static class BadDependency{
		public BadDependency() {
			throw new IllegalStateException();
		}
	}
}
