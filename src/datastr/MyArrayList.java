package datastr;

import java.util.ArrayList;

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
	
	public void add(char element, int index) throws IllegalAccessException {
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams pievienot elementu, indekss nevar but negativs (index out of bounds for list)!");
		}
		
		if(index >= howManyElements) {
			throw new IllegalArgumentException("Nav iespejams pievienot elementu, indekss ir parak liels (index out of bounds for list)!"); 
		}
		
		if(index == howManyElements) {
			add(element);
			return;
		}
		
		if(isFull()) {
			resize();
		}
		
		for(int i = howManyElements; i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = element;
		howManyElements++;
	}
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public void remove(int index) throws IllegalArgumentException {
		if(isEmpty()) {
			throw new IllegalArgumentException("List ir tukss, nevar dzest elementu!");
		}
		
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams dzest elementu, indekss nevar but negativs (index out of bounds for list)!");
		}
		
		if(index >= howManyElements) {
			throw new IllegalArgumentException("Nav iespejams dzest elementu, indekss ir parak liels (index out of bounds for list)!"); 
		}
		
		for(int i = index; i < howManyElements-1; i--) {
			list[i] = list[i+1];
		}
		list[howManyElements-1] = ' ';
		howManyElements--;
	}
	
	public char get(int index) throws IllegalArgumentException {
		if(isEmpty()) {
			throw new IllegalArgumentException("List ir tukss, nevar iegut elementu!");
		}
		
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams iegut elementu, indekss nevar but negativs (index out of bounds for list)!");
		}
		
		if(index >= howManyElements) {
			throw new IllegalArgumentException("Nav iespejams iegut elementu, indekss ir parak liels (index out of bounds for list)!"); 
		}
		
		return list[index];
	}
	
	public int[] search(char element) throws Exception {
		if(isEmpty()) {
			throw new Exception("List ir tukss, nevar sameklet elementu!");
		}
		
		ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
		for(int i = 0; i < howManyElements; i++) {
			if(list[i] == element) {
				indexArrayList.add(i);
			}
		}
		
		int howManyIndexes = 0;
		for(int i = 0; i < howManyElements; i++) {
			if(list[i] == element) {
				howManyIndexes++;
			}
		}
		
		int[] indexArray = new int[howManyIndexes];
		int indexForIndexesArray = 0;
		for(int i = 0; i < howManyElements; i++) {
			if(list[i] == element) {
				indexArray[indexForIndexesArray] = i;
				indexForIndexesArray++;
			};
		}
		
		if(indexForIndexesArray == 0) {
			throw new Exception("List neeksiste '" + element  + "' elements!");
		}
		
		return indexArray;
	}
}


















