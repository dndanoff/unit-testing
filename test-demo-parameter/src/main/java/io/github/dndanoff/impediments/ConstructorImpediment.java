package io.github.dndanoff.impediments;

public class ConstructorImpediment {
	
	private DbDependency dbDependency;
	private SlowDependency slowDependency;
	
	public ConstructorImpediment() {
//		init();
		this.dbDependency = new DbDependency();
		this.slowDependency = new SlowDependency();
	}
	
//	void init(){
//		this.dbDependency = new DbDependency();
//		this.slowDependency = new SlowDependency();
//	}
	
	public String greet() {
		return "Hello world!";
	}
	
	public static class DbDependency{
		public DbDependency() {
			throw new IllegalStateException("test impediment");
		}
	}
	
	public static class SlowDependency{
		public SlowDependency() {
			throw new IllegalStateException("test impediment");
		}
	}
}
