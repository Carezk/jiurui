package com.jiurui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author zk
 * @date 2018年9月6日
 */
public class JdbcUtils {
	static String Driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/zhang?characterEncoding=utf-8";
	static String username = "root";
	static String password = "1234";

	public static void writeToMysql(Student student) {
		System.out.println(student);

		try {
			Class.forName(Driver);

		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
		Statement st = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String name = student.getName();
			String sex = student.getSex();
			String idcard = student.getIdcard();

			String sql = "insert into stu(name,sex,idcard) values(\"" + name + "\",\"" + sex + "\",\"" + idcard + "\")";
			System.out.println(sql);
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
