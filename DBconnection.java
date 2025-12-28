package combankmain;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static Connection con;
public static Connection getConnection() {
	try {
		if(con == null || con.isClosed()) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
	
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
return con;
}
}
