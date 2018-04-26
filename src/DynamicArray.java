
public class DynamicArray {

	private final int defaultInitCapacity = 10;

	private int[] firstArray;
	private int[] secondArray;
	private boolean isInTwoArrayState;
	private int nextIndexToInsert;
	private int nextIndexToCopy;

	public DynamicArray() {
		nextIndexToInsert = 0;
		nextIndexToCopy = 0;
		firstArray = new int[defaultInitCapacity];
		secondArray = null;
		isInTwoArrayState = false;
	}

	public void push(int newNumber) {
		if (nextIndexToInsert < firstArray.length ) {
			firstArray[nextIndexToInsert] = newNumber;
			nextIndexToInsert++;
			
		} else {
			if (!isInTwoArrayState) {
			secondArray = new int[firstArray.length * 2];
			isInTwoArrayState = true;
			}
			secondArray[nextIndexToInsert] = newNumber;
			nextIndexToInsert++;
			rewriteArray();
		}
	}

	public int pop () {
		int valueOflastElement = nextIndexToInsert - 1;
		nextIndexToInsert--;
		if(nextIndexToInsert < firstArray.length) {
			secondArray = null;
			isInTwoArrayState = false;
		}
		return valueOflastElement;
	}


	private void rewriteArray() {
			secondArray[nextIndexToCopy] = firstArray[nextIndexToCopy];
			nextIndexToCopy++;
			
			if (nextIndexToCopy >= firstArray.length) {
			firstArray = secondArray;
			secondArray = new int[firstArray.length * 2];
			secondArray[nextIndexToCopy] = firstArray[nextIndexToCopy];
			nextIndexToCopy = 0;
			}
	}



	public int get(int index) {

		if (isOutOfRange(index)) {
			throw new IndexOutOfBoundsException();
		}

		if (index < firstArray.length) {
			return firstArray[index];
		} else {
			return secondArray[index];
		}
	}

	boolean isOutOfRange(int index) {
		return index < 0 || index > nextIndexToInsert;
	}

}
