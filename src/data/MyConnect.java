package data;

import java.sql.*;

public class MyConnect {
	public static Connection getConnection() {
		try {
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			return DriverManager.getConnection("jdbc:mysql://localhost/stou_zaab","root","");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		if(getConnection() != null){
			System.out.println("Database Connected.");
			} else {
			System.out.println("Database Connect Failed.");
			}
	}*/
}