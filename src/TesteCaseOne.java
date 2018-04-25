import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TesteCaseOne {
	
	private String makeMessage (int expected, int acctual) {
		StringBuilder sb = new StringBuilder();
		sb.append("Tested value is ");
		sb.append(expected);
		sb.append("Acctual value is: ");
		sb.append(acctual);
		return sb.toString();
	}

	@Test
	public void test() {
		DynamicArray testedObject = new DynamicArray();
		List <Integer> mock = new ArrayList <Integer> ();
		for (int i = 0; i < 20 ; i++) {
			mock.add(i);
			testedObject.add(i);
		}
		
		for (int i = 0; i < mock.size(); i++) {
			int mockVal = mock.get(i);
			int tObjVal = testedObject.get(i);
			assertEquals(mockVal , tObjVal);
		}
	}

}
