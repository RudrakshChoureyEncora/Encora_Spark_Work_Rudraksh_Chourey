package JdbcDemoPack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcDemo2 {
	public static void main(String[] args) {
		try(Connection con=
				DriverManager.getConnection
				("jdbc:mysql://localhost/encorarudraksh","root","root123");){
			PreparedStatement ps=
					con.prepareStatement
					("select * from employees where eid=?");
			BufferedReader in=
					new BufferedReader
					(new InputStreamReader(System.in));
			
			
			while(true) {	
				System.out.println("Please enter employee id..:");
				int eid=new Scanner(System.in).nextInt();
				System.out.println("You Entered..:"+eid);
				ps.setInt(1,eid);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("eid"));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}