package io.github.dndanoff.solved;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import io.github.dndanoff.solved.ConverterService;

public class ConverterServiceTest {
	
	ConverterService objUnderTest;
	
	@Before
	public void setup() {
		objUnderTest = new ConverterService();
	}
	
	@Test
	public void convert_should_return_null_when_number_is_null() {
		assertNull(objUnderTest.convert(null));
	}
	
	@Test
	public void convertTest_should_return_foo_when_number_is_three() {
		assertEquals("foo", objUnderTest.convert(3));
	}
	
	@Test
	public void convert_should_return_foobar_when_input_is_five_and_three() {
		assertEquals("foobar", objUnderTest.convert(15));
	}
}
