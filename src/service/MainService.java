package service;

import java.util.Arrays;

import datastr.MyArrayList;

public class MainService {
	public static void main(String[] args) {
		MyArrayList symbols = new MyArrayList(3);
		symbols.add('a');
		symbols.add('b');
		symbols.add('c');
		symbols.add('a');
		
		try
		{
			symbols.print();
			symbols.add('Z', 1);
			symbols.print();
			symbols.remove(2);
			symbols.print();
			System.out.println(symbols.get(1));
			System.out.println(symbols.search('a'));
			System.out.println(Arrays.toString(symbols.getNextElements('a')));
			symbols.sort();
			symbols.print();
			symbols.makeEmpty();
			symbols.add('W');
			symbols.print();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
