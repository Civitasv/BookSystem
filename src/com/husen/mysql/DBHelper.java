package com.husen.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	static String url;
	static Properties pro = new Properties();
	static{
		InputStream in = DBHelper.class.getResourceAsStream("config.properties");
		try {
			pro.load(in);
			url = pro.getProperty("url");
			String driver = pro.getProperty("driver");
			Class.forName(driver);
			System.out.println("���������سɹ�");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("����������ʧ��");
		}
	}
	public static Connection getConnection() throws SQLException{
		//�������ݿ�����
		Connection con = DriverManager.getConnection(url, pro);
		return con;
	}
}
