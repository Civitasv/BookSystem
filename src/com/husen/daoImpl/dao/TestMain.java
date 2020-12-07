package com.husen.dao;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		
		ArrayList<Object> list2 = new ArrayList<>();
		
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		list.deleteByIndex(2);
		System.out.println(list);
		list.delete(2);
		System.out.println(list);
		
	}
}
