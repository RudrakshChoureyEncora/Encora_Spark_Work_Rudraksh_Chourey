package JdbcDemoPack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcDemo3 {
	public static void main(String[] args) {
		System.out.println("hello");
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encorarudraksh","root","root123")){
			
			CallableStatement c=con.prepareCall("call GetMostOldestJoinDate(?)");
			c.registerOutParameter(1, Types.DATE);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
