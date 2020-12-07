package com.husen.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyArrayList<T> {

	// 根据HashMap实现ArrayList
	private HashMap<Integer, T> map = new HashMap<Integer, T>();

	// 增
	public void add(T t) {
		map.put(map.size(), t);
	}

	// 删
	public void delete(T t) {
		int index = 0;
		for (int i = 0; i < map.size(); i++) {
			if (map.get(i) == t) {
				map.remove(i);
				index = i;
			}
		}
		for(int i =index;i<map.size();i++) {
			map.put(i, map.get(i+1));
		}
		map.remove(map.size()-1);
	}
	// 删
	public void deleteByIndex(int index) {
		map.remove(index);
		for(int i =index;i<map.size();i++) {
			map.put(i, map.get(i+1));
		}
		map.remove(map.size()-1);
	}
	// 查
	public T get(int index) {
		return map.get(index);
	}

	@Override
	public String toString() {
		System.out.println(map.size());
		String str = "";
		str += "[";
		for (int i = 0; i < map.size() - 1; i++) {
			str += map.get(i);
			str += ",";
		}
		str += map.get(map.size() - 1);
		str += "]";
		return str;
	}
}
