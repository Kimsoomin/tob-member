package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseImpl implements Database{
	Constants constants = new Constants();
	
	private String driver, url, userid, password;
	private Connection connection;
	
	public DatabaseImpl(String driver, String url, String userid, String password) {
		this.driver = driver;
		this.url = url;
		this.userid = userid;
		this.password = password;		
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,userid,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}	
}
