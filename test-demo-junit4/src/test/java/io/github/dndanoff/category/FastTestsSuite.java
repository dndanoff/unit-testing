package io.github.dndanoff.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(FastTests.class)
@SuiteClasses( { CategoryTest.class, MoreCategoryTest.class })
public class FastTestsSuite {

}
