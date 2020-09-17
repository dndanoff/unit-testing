package io.github.dndanoff.rules;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWatcherTest {
	private static String msg = "";
	@Rule
	public TestWatcher watchman = new TestWatcher() {
		@Override
		public Statement apply(Statement base, Description description) {
			System.out.println("apply");
			return super.apply(base, description);
		}

		@Override
		protected void succeeded(Description description) {
			msg += description.getDisplayName() + " " + "success!\n";
		}

		@Override
		protected void failed(Throwable e, Description description) {
			msg += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
		}

		@Override
		protected void starting(Description description) {
			super.starting(description);
			System.out.println("starting");
		}

		@Override
		protected void finished(Description description) {
			super.finished(description);
			System.out.println("finished");
		}
	};

	@Test
	public void red_test() {
		assertTrue(false);
	}

	@Test
	public void green() {
	}

	@AfterClass
	public static void afterClass() {
		System.out.println(msg);
	}
}
