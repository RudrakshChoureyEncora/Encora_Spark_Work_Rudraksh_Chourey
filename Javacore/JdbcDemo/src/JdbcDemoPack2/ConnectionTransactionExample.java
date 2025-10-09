package JdbcDemoPack2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
import java.util.UUID;

import DTADAO.ConnectionUtility;

public class ConnectionTransactionExample {
	public static void main(String[] args) {
		Connection con=ConnectionUtility.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id from which you want to debit: ");
		String fromId=sc.nextLine();
		System.out.print("Enter the id in which you want to credit: ");
		String toId=sc.nextLine();;
		System.out.print("Enter the balance you want to Transact: ");
		int ammount=sc.nextInt();
		String tId=UUID.randomUUID().toString();
		
		
		Savepoint sp=null;
		try {
		//con.setAutoCommit(false);
		PreparedStatement ps1=con.prepareStatement("insert into logger values(?,?,?,?,?)");
		ps1.setString(1,fromId);
		ps1.setString(2,toId);
		ps1.setInt(3, ammount);
		ps1.setString(4,"Transaction Started");
		ps1.setString(5,tId);
		ps1.execute();
		sp=con.setSavepoint("Transaction starting log...");
		
		//Point1
		CallableStatement cs=con.prepareCall("call getUserBalance(?,?)");
		cs.setString(1, fromId);
		cs.registerOutParameter(2,Types.INTEGER);
		cs.execute();
		int fromBal=cs.getInt(2);
		CallableStatement cs4=con.prepareCall("call getUserBalance(?,?)");
		cs4.setString(1, toId);
		cs4.registerOutParameter(2,Types.INTEGER);
		cs4.execute();
		int toBal=cs.getInt(2);
		CallableStatement cs2=con.prepareCall("call getUserStatus(?,?)");
		cs2.setString(1, fromId);
		cs2.registerOutParameter(2,Types.INTEGER);
		cs2.execute();
		int fromFreezeStatus=cs.getInt(2);
		CallableStatement cs3=con.prepareCall("call getUserStatus(?,?)");
		cs3.setString(1, toId);
		cs3.registerOutParameter(2,Types.INTEGER);
		cs3.execute();
		int toFreezeStatus=cs.getInt(2);
		if(fromBal<ammount || fromFreezeStatus==1 || toFreezeStatus==1) {
			throw new IllegalArgumentException();
		}
		else {
			//Point2
			PreparedStatement ps=
					con.prepareStatement("update bankAccount set balance=? where userid=?");
			ps.setInt(1, fromBal-ammount);
			ps.setString(2, fromId);
			ps.executeUpdate();
			ps.setInt(1, toBal-ammount);
			ps.setString(2, toId);
			ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("update logger set status=? where tansactid=?");
			ps2.setString(1, "Successfull");
			ps2.setString(2, tId);
			ps2.executeUpdate();
			try{ConnectionUtility.closeConnection(null,null);}catch(Exception ee) {ee.printStackTrace();}
		}
		}catch(Exception e) {
			e.printStackTrace();
			try{
				PreparedStatement ps2=con.prepareStatement("update logger set status=? where tansactid=?");
				ps2.setString(1, "Failed");
				ps2.setString(2, tId);
				ps2.executeUpdate();
				ConnectionUtility.closeConnection(e,sp);}catch(Exception ee) {ee.printStackTrace();}
		}
	}
}

