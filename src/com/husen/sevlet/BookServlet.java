package com.husen.sevlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.husen.dao.AccountDao;
import com.husen.dao.BookDao;
import com.husen.dao.CategoryDao;
import com.husen.daoImpl.AccountDaoImpl;
import com.husen.daoImpl.BookDaoImpl;
import com.husen.daoImpl.CategoryDaoImpl;
import com.husen.entity.Account;
import com.husen.entity.Book;
import com.husen.entity.Category;
import com.husen.entity.Page;

/*
 * 使用联表查询
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 1，登陆界面 2，书籍列表界面 3，登陆判断
	 * 
	 */
	private BookDao bookDao = new BookDaoImpl();
	private AccountDao accountDao = new AccountDaoImpl();
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到前台传来的请求
		String action = req.getParameter("op");
		if (action == null || "login".equals(action)) {
			login(req, resp);
		} else if ("list".equals(action)) {
			list(req, resp);
		} else if ("delete".equals(action)) {
			delete(req, resp);
		} else if ("getById".equals(action)) {
			getById(req, resp);
		} else if ("change".equals(action)) {
			changeIt(req, resp);
		} else if ("regist".equals(action)) {
			regist(req, resp);
		} else if ("add".equals(action)) {
			add(req, resp);
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookName = req.getParameter("BookName");
			String author = req.getParameter("author");
			int category = Integer.parseInt(req.getParameter("categoryId"));
			System.out.println(category);
			double price = Double.parseDouble(req.getParameter("price"));
			Date pubdate = new SimpleDateFormat("YYYY-MM-DD").parse(req.getParameter("pubdate"));
			int size = bookDao.getAll().size();
			bookDao.add(new Book(size + 1, bookName, author, price, pubdate, category));
		} catch (ParseException e) {
			System.out.println("解析不成功");
		}
		resp.sendRedirect("book?op=list");
	}

	private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 用户注册账户
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		String passwordsu = req.getParameter("pwdsure");
		if (!(password.equals(passwordsu))) {
			req.setAttribute("msg", "两次密码不相同");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		} else if (accountDao.getByName(username) != null) {
			req.setAttribute("msg2", "用户名重复，请重新注册");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		} else {
			Account account = new Account(username, password);
			accountDao.add(account);
			req.setAttribute("msg3", "注册成功,请登陆");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	private void changeIt(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bookName = req.getParameter("BookName");
			String author = req.getParameter("author");
			int category = Integer.parseInt(req.getParameter("categoryId"));
			double price = Double.parseDouble(req.getParameter("price"));
			Date pubdate = new SimpleDateFormat("YYYY-MM-DD").parse(req.getParameter("pubdate"));
			bookDao.update(new Book(id, bookName, author, price, pubdate, category));
		} catch (ParseException e) {
			System.out.println("解析不成功");
		}
		resp.sendRedirect("book?op=list");
	}

	private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = bookDao.getById(Integer.parseInt(req.getParameter("id")));
		/*List<Category> clist = categoryDao.getAll();
		req.setAttribute("clist", clist);*/
		req.setAttribute("id", req.getParameter("id"));
		req.setAttribute("book", book);
		req.setAttribute("bookName", book.getName());
		req.getRequestDispatcher("getById.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		// 查询
		Book book = bookDao.getById(id);
		bookDao.delete(book);
		List<Book> list = bookDao.getAfterId(id);
		for (Book bk : list) {
			bookDao.updateId(bk);
			System.out.println("更新成功");
		}
		System.out.println(book.getId());
		System.out.println("删除成功");
		resp.sendRedirect("book?op=list");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*List<Category> clist = categoryDao.getAll();
		req.setAttribute("clist", clist);*/
		Page page = new Page();
		page.setPageSize(3);
		page.setTotalCount(bookDao.getAll().size());
		// 默认页码是1
		int currentPage = 1;
		if (req.getParameter("currentPage") != null) {
			try {
				currentPage = Integer.parseInt(req.getParameter("currentPage"));
			} catch (NumberFormatException e) {
				currentPage = 1;
			}
		}
		page.setCurrentPage(currentPage);
		List<Book> list = bookDao.getAllBook(page);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.getRequestDispatcher("admin/list.jsp").forward(req, resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		if (accountDao.getByName(username) != null && password.equals(accountDao.getByName(username).getPassword())) {
			System.out.println("登陆成功");
			req.getSession().setAttribute("user", accountDao.getByName(username));
			resp.sendRedirect("book?op=list");
		} else {
			req.setAttribute("msg", "账号或者密码错误，请重新输入!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
