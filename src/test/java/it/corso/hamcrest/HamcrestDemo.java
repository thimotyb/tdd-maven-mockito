package it.corso.hamcrest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * http://www.vogella.com/tutorials/Hamcrest/article.html
 * 
 * Caution: Check that in "Build Path > Order and Export" Hamcrest precedes Junit
 * 
 * @author thimo
 *
 */
public class HamcrestDemo {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	String expected = "Ciao";
	String actual = "Ciao";
	
	@Test
	public void test() {
		
		// JUnit 4 for equals check
		assertEquals(expected, actual);
		// Hamcrest for equals check
		assertThat(actual, is(equalTo(expected)));

		// JUnit 4 for not equals check
		assertNotEquals(expected, actual);
		// Hamcrest for not equals check
		assertThat(actual, is(not(equalTo(expected))));
		
		// It is also possible to chain matchers, via the anyOf of allOf method.
		assertThat("test", anyOf(is("testing"), containsString("est")));
		
		assertThat(Long.valueOf(1), instanceOf(Integer.class));
		
	}

	/**
	 * Matchers for Lists
	 */
	@Test
    public void listShouldInitiallyBeEmpty() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, hasSize(3));

        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));

        assertThat(list, containsInAnyOrder(2, 4, 5));

        assertThat(list, everyItem(greaterThan(1)));
               
        assertThat(list, both(hasSize(1)).and(contains(42)));
        
     // Check that a list of objects has a property race and
     // that the value is not ORC
     // assertThat(fellowship, everyItem(hasProperty("race", is(not(("ORC"))))));

    }
	
}
