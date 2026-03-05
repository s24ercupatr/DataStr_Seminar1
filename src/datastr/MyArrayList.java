package datastr;

public class MyArrayList {
	private char[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	public MyArrayList() {
		list = new char[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 10000) {
			size = inputSize;
		}
		list = new char[size];
	}

	private boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	private boolean isFull() {
		return (howManyElements == size);
	}
	
	private void resize() {
		int newSize = (howManyElements < 200) ? (size * 2) : (int)(size * 1.5);
		char[] newList = new char[newSize];

		for(int i = 0; i < howManyElements; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		size = newSize;
		System.gc();
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		
		list[howManyElements++] = element;
		//howManyElements++;
	}
}


















