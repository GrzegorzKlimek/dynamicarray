import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
!fdfd
public class TesteCaseOne {
	

	@Test
	public void pushTest() {
		DynamicArray testedObject = new DynamicArray();
		List <Integer> mock = new ArrayList <Integer> ();
		for (int i = 0; i < 1000 ; i++) {
			mock.add(i);
			testedObject.push(i);
		}
		
		for (int i = 0; i < mock.size(); i++) {
			int mockVal = mock.get(i);
			int tObjVal = testedObject.get(i);
			assertEquals(mockVal , tObjVal);
		}
	}

	@Test
	public void popTest () {
		DynamicArray testedObject = new DynamicArray();
		List <Integer> mock = new ArrayList <Integer> ();
		for (int i = 0; i < 1000 ; i++) {
			mock.add(i);
			testedObject.push(i);
		}

		for (int i = 0; i < 500; i++) {
			mock.remove(mock.size() -1);
			testedObject.pop();
		}

		for (int i = 0; i < mock.size(); i++) {
			int mockVal = mock.get(i);
			int tObjVal = testedObject.get(i);
			assertEquals(mockVal , tObjVal);
		}
	}
}
