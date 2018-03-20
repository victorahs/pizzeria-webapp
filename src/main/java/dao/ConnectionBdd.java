package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionBdd {
	
	
	
	public Connection connectionJdbc() throws SQLException{
		
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String pswd = bundle.getString("pswd");
		try {
			Class.forName(bundle.getString("driver"));
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver introuvable :"+e.getMessage());
		}
		Connection conn = DriverManager.getConnection(url, user, pswd);
		
		return conn;
		
		
		
		
	}
	

}
