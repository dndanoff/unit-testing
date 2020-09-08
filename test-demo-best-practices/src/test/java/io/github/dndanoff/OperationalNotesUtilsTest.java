package io.github.dndanoff;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class OperationalNotesUtilsTest {
	
	private static final String GOOD2GO = "GOOD2GO";
	private static final String ROUTE_LOCK = "ROUTELOCK";
	
	private OperationalNotesUtils objUnderTest;
	
	@Parameters(name = "{index}: extractTags({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
			{ null, new HashSet<>() },
			{ "", new HashSet<>() },
			{ "#GOOD2GO", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO some other notes", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO some other notes #GOOD2GO", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO and notes and another tag #ROUTELOCK", new HashSet<>(Arrays.asList(GOOD2GO, ROUTE_LOCK)) },
			{ "test with unknown tags #SOMETAG #TEST", new HashSet<>() },
			{ "test case insensitive tag #Good2GO", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO\rtest with new line", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO\ntest with new line", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO\r\ntest with new line", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ " #GOOD2GO test with leading space", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO\ttest with tab", new HashSet<>(Arrays.asList(GOOD2GO)) },
			{ "#GOOD2GO\n\ntest with multiple new lines", new HashSet<>(Arrays.asList(GOOD2GO)) }
        });
    }
    
    @Parameter // first data value (0) is default
    public /* NOT private */ String operationalNotes;

    @Parameter(1)
    public /* NOT private */ Set<String> expectedTags;
	
    @Before
    public void setup() {
    	objUnderTest = new OperationalNotesUtils(Arrays.asList("#"+GOOD2GO,"#"+ROUTE_LOCK));
    }
    
    @Test
	public void extractTagsFromMemoTest() {
    	assertEquals(expectedTags, objUnderTest.extractTagsFromOperationalNotes(operationalNotes));
	}
}
