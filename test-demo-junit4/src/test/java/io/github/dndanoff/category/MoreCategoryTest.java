package io.github.dndanoff.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTests.class, FastTests.class})
public class MoreCategoryTest {
	@Test
	public void c() {
	}
}
