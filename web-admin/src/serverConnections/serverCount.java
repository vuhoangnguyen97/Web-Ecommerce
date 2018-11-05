package serverConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Database;

public class serverCount {
	public static int count() {
		int countConnect = 0;
		try {
			String sql = "show status where `variable_name` = 'Threads_connected'";
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				countConnect = rs.getInt("Value");
				System.out.println(countConnect+"");
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countConnect;
	}
}
