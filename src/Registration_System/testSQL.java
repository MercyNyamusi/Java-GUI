package Q2;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection Conn =null;
			String query;
			Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registartionsystem_javasummative", "root", "");
			java.sql.Statement Stmt= Conn.createStatement();
//			String Name = "MercyNyamusi";
//			String word ="123456789";
//			int output = Stmt.executeUpdate("INSERT INTO login_details(UserName, Password)VALUES ('"+Name+"', '"+word+"')");
//			System.out.println(output);
			ResultSet res= Stmt.executeQuery("select COUNT(*) AS count from student_details WHERE Course='Computer Science'");
			while(res.next()) {
				System.out.println(res.getInt("count"));
			}
			
			
		}			
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Problem: "+e.getMessage());
		}
		
	}
}

