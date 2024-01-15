package it.corso.mockito;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SpyDemo {

	@Spy
	List<String> myList = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
	
		myList.add("Thimoty");
		myList.add("Barbieri");
		
		// Mockito.when(myList.get(0)).thenReturn("Alex");

		// When using @Spy:
		Mockito.doReturn(3).when(myList).size();
		assertSame(3, myList.size());
		
		// When using @Mock:
		// Mockito.when(myList.size()).thenCallRealMethod();
		
		
	}

}
