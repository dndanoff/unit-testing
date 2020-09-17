package io.github.dndanoff.category;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryTest {
	@Test
	public void a() {
		assertTrue(false);
	}

	@Category(SlowTests.class)
	@Test
	public void b() {
	}
}
