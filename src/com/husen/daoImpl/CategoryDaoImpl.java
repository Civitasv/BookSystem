package com.husen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.husen.dao.CategoryDao;
import com.husen.entity.Book;
import com.husen.entity.Category;
import com.husen.mysql.DBHelper;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public Category getById(int id) {
		Category category = new Category();
		String sql = "select id,category from categories where id="+ id;
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				category.setCategory(rs.getString("category"));
				category.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> getAll() {
		List<Category> list = new ArrayList<Category>();
		String sql = "select *from categories";
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategory(rs.getString("category"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Category getByName(String name) {
		Category category = new Category();
		String sql = "select id,category from categories where category="+ name;
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				category.setCategory(rs.getString(name));
				category.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

}
