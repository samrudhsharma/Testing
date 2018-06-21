import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.hamcrest.CoreMatchers.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
class HamcrestExampleTest {

	@Test
	public void mapShouldContainValue() {
		
		Map<String, Integer> values = getValues();
		//assertTrue(values.containsKey("A"), "The map does not contain the key");// This does not give us very good diagnostics so we can use Hamcrest Matchers
		assertThat(values, hasKey("a"));
		
	}

	private HashMap<String, Integer> getValues() {
		final HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);

		return map;
	}
	
	@Test
	public void listOrderingIsIrrelevant() {
		List<Integer> numbers = getNumbers();
		//assertEquals(5, (int) numbers.get(4), "The numbers in the list don't match");
		assertThat(numbers, hasItem(5));
	}

	private List<Integer> getNumbers() {
		
		return Arrays.asList(1, 2, 3, 4, 5);
	}

}

