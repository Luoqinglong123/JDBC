package com.lql.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

public class SqlUtils {
	private static Connection connection = null;
	private static String className = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static Properties ps = null;
	static {
		try {
			ps = new Properties();
			InputStream inputStream = SqlUtils.class.getClassLoader()
					.getResourceAsStream("db.properties");
			ps.load(inputStream);
			className = ps.getProperty("driver");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Class.forName(className);
			
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static long getItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	public static void closeRealse(PreparedStatement ps, Connection connection,
			ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
