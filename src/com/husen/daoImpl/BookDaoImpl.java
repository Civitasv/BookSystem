package com.husen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.husen.dao.BookDao;
import com.husen.entity.Book;
import com.husen.entity.Page;
import com.husen.mysql.DBHelper;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> getAllBook(Page page) {
		List<Book> list = new ArrayList<Book>();
		String sql = "select *from book limit "+(page.getCurrentPage()-1)+","+page.getPageSize();
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setPubdate((java.util.Date) rs.getDate("pubDate"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getInt("category"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book getById(int id) {
		Book book = new Book();
		String sql = "select id,name,price,author,pubDate,category from book where id=" + id;
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				book.setId(id);
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setPubdate((java.util.Date) rs.getDate("pubDate"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getInt("category"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int add(Book book) {
		// sql语句
		String sql = "insert into book(id,name,price,author,pubDate,category)values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 0.加载驱动
			// 1.创建数据库连接
			conn = DBHelper.getConnection();
			// 2.创建预处理对象
			pstmt = conn.prepareStatement(sql);
			// 3.绑定参数
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setDouble(3, book.getPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(book.getPubdate()));
			pstmt.setInt(6, book.getCategory());
			// 4.插入
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public int delete(Book book) {
		String sql = "delete from book where id=" + book.getId();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBHelper.getConnection();
			pstmt = con.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return -1;
	}

	@Override
	public int update(Book book) {
		String sql = "update book set name=?,price=?,author=?,pubDate=?,category=? where id=" + book.getId();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBHelper.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setDouble(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, new SimpleDateFormat("yyyy-MM-DD").format(book.getPubdate()));
			pstmt.setInt(5, book.getCategory());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return -1;
	}

	@Override
	public int updateId(Book book) {
		String sql = "update book set id="+(book.getId()-1);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBHelper.getConnection();
			pstmt = con.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return -1;
	}

	@Override
	public List<Book> getAfterId(int id) {
		List<Book> list = new ArrayList<Book>();
		String sql = "select *from book where id>"+id;
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setPubdate((java.util.Date) rs.getDate("pubDate"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getInt("category"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book> getAll() {
		List<Book> list = new ArrayList<Book>();
		String sql = "select *from book";
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setPubdate((java.util.Date) rs.getDate("pubDate"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getInt("category"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
