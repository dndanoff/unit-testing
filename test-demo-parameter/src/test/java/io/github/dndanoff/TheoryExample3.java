package io.github.dndanoff;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryExample3 {

	@Theory
	public void build(@ParametersSuppliedBy(DataSupplier.class) String c, @ParametersSuppliedBy(DataSupplier.class) String d) {
		System.out.println(c + d);
	}
}
