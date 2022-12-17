package utility;

import java.sql.*;
import java.util.Properties;
public class Connection {
	
	public static java.sql.Connection c;
	
	public static void connection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Pilote non trouv�!");
			e.printStackTrace();
		}
		
		Properties userInfo = new Properties();
		userInfo.setProperty("user", User.userName);
		userInfo.setProperty("password", User.password);
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:"+User.port+"/"+User.schemaName, userInfo); 
			if (c.isValid(0))
				System.out.println("Connexion r�ussie ! \n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}