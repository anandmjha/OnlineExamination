package com.onlineExamination.util;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DBUtil {
	
	
	private static DataSource ds;
	
	
	
	static {
		try {
			InitialContext ic = new InitialContext();
			System.out.println("Ic Created....." + ic);
			ds = (DataSource) ic.lookup("java:comp/env/myds");
			System.out.println("Ds Created..."+ds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DBUtil() {
		
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
		
	}
	public static void close(Connection con){
		if(con!=null)
			try {
				con.close();
				System.out.println("connection closed");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
}
