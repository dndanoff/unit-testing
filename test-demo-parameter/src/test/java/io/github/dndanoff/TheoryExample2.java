package io.github.dndanoff;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryExample2 {
	@DataPoint
	public static String a = "A";
	@DataPoint
	public static String b = "Z";

	@Theory
	public void build(String c, String d) {
		System.out.println(c + d);
	}
}
