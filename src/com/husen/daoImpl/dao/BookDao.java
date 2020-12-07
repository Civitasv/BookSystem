package com.husen.dao;

import java.util.List;

import com.husen.entity.Book;
import com.husen.entity.Page;

public interface BookDao {
	public List<Book> getAll();
	
	public List<Book> getAllBook(Page page);
	
	public Book getById(int id);
	
	public int add(Book book);
	
	public int delete(Book book);
	
	public int update(Book book);
	
	public int updateId(Book book);
	
	public List<Book> getAfterId(int id);
	
} 
