package com.husen.dao;

import java.util.List;

import com.husen.entity.Account;


public interface AccountDao {

	public List<Account> getAll();
	
	public Account getByName(String username);
	
	public int add(Account account);
	
	public int delete(Account account);
	
	public int update(Account account);
}
