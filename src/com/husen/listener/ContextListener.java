package com.husen.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.husen.dao.CategoryDao;
import com.husen.daoImpl.CategoryDaoImpl;
import com.husen.entity.Category;

@WebListener
public class ContextListener implements ServletContextListener {
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Category> clist = categoryDao.getAll();
		sce.getServletContext().setAttribute("clist", clist);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
