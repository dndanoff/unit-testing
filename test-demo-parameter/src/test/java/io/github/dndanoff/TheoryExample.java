package io.github.dndanoff;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryExample {
	@DataPoints
	public static String[] chars = { "A", "B", "C" };

	@Theory
	public void build(String c, String d) {
		System.out.println(c + " " + d);
	}
}
