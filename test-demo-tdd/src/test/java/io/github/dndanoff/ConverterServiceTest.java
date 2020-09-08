package io.github.dndanoff;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConverterServiceTest {

	@Test
	public void convert_should_return_foo_when_input_is_three() {
		ConverterService objUnderTest = new ConverterService();
		String actual = objUnderTest.convert(3);
		assertEquals("foo", actual);
	}
	
	@Test
	public void convert_should_return_bar_when_input_is_five() {
		ConverterService objUnderTest = new ConverterService();
		String actual = objUnderTest.convert(5);
		assertEquals("bar", actual);
	}
	
	@Test
	public void convert_should_return_foobar_when_input_is_five_and_three() {
		ConverterService objUnderTest = new ConverterService();
		String actual = objUnderTest.convert(15);
		assertEquals("foobar", actual);
	}
}
