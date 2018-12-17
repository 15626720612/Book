package pub.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**获取数据库连接*/
public class Database {
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/reading"
					, "root"
					, "root");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Database.getConnection());
	}

}
