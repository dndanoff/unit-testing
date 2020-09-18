package io.github.dndanoff;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

//@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceTest {

//	@Mock
	private GreetingService mock;
	
//	@Rule 
//	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setup() {
//		MockitoAnnotations.initMocks(this);
		mock = Mockito.mock(GreetingService.class);
	}
	
	@Test
	public void sanity() {
		String actual = mock.greet("Denis");
		verify(mock, times(1)).greet(argThat(is("Denis")));
		assertNull(actual);
	}
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
}
