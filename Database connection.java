package busres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	private static final String url = "jdbc:mysql://localhost:3306/busresve";
	private static final String userName = "root";
	private static final String passWord = "kishore@07";
	
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}

}
