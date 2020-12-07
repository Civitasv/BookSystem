package com.husen.dao;

import java.util.List;

import com.husen.entity.Category;

public interface CategoryDao {
	
	public Category getById(int id);
	
	public List<Category> getAll();
	
	public Category getByName(String name);
}
