package JdbcDemoPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDem {
	public static void main(String[] args) {
		/*
		 * jdbc Connection:
		 * 
		 * 1. register the driver// no need to add the driver after jdk6 2006
		 * 2. establish the connection
		 * 3. create a sql statement
		 * 4. execute and Process
		 */
		
//		Connection con=null;
		try (Connection con=DriverManager.getConnection("JDBC:mysql://localhost/encorarudraksh","root","root123");){
			System.out.println(con);
			Statement stmt=con.createStatement();
			String sql = "Select * from employees";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("ename"));
				System.out.println("sdf");
			}
//			System.out.println(stmt.execute("Create table abc(a varchar(1),b int(1));"));
//			stmt.addBatch("insert into ")
//			System.out.println(stmt.executeBatch());
		
//			System.out.println(stmt.execute("call proc2();"));
			ResultSet rs2=stmt.executeQuery("call getmostrecdet()?");//
			
			System.out.println("trying");
			while(rs2.next()) {
				System.out.println(rs2.getString("uname"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
}
