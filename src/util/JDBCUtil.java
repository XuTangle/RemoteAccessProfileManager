package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.activation.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class JDBCUtil {
	
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	public static void release(Connection conn, Statement st, ResultSet rs) {
		// Releases the resources after use
	}
	
}
