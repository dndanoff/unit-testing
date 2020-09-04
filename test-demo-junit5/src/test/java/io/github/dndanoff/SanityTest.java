package io.github.dndanoff;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SanityTest {
	@BeforeAll
	public static void beforeClass() {
		System.out.println("***Before Class is invoked");
	}

	@BeforeEach
	public void before() {
		System.out.println("____________________");
		System.out.println("\t Before is invoked");
	}

	@AfterEach
	public void after() {
		System.out.println("\t After is invoked");
		System.out.println("=================");
	}

	@Test
	public void someTest() {
		System.out.println("\t\t someTest is invoked");
	}

	@Test
	public void someTest2() {
		System.out.println("\t\t someTest2 is invoked");
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("***After Class is invoked");
	}
}
