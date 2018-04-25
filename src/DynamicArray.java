
public class DynamicArray {

	private final int defaultInitCapacity = 10;

	private int[] firstArray;
	private int[] secondArray;

	private int capacity;
	private int nextIndexToInsert;
	private int nextIndexToCopy;

	public DynamicArray() {
		nextIndexToInsert = 0;
		nextIndexToCopy = 0;
		capacity = defaultInitCapacity;
		firstArray = new int[capacity];
		secondArray = new int[capacity * 2];
	}

	public void add(int newNumber) {
		if (nextIndexToInsert < firstArray.length ) {
			firstArray[nextIndexToInsert] = newNumber;
			nextIndexToInsert++;
			
		} else {
			rewriteArray();
			secondArray[nextIndexToInsert] = newNumber;
			nextIndexToInsert++;
		}
	}

	private void rewriteArray() {
			secondArray[nextIndexToCopy] = firstArray[nextIndexToCopy];
			nextIndexToCopy++;
			
			if (nextIndexToCopy >= firstArray.length) {
			firstArray = secondArray;
			capacity *= 2;
			secondArray = new int[capacity * 2];
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