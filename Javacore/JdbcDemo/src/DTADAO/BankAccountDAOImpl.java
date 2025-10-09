package DTADAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class BankAccountDAOImpl implements GeneralDAO<BankAccountDTO>{
	private Connection con=null;
	

	public BankAccountDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	public void setCon(Connection con) {
		this.con=con;
	}
	
	@Override
	public ArrayList<BankAccountDTO> findAll() {
		ArrayList<BankAccountDTO> users=new ArrayList<>(); 	
		System.out.println("Finding all");
	    try  {
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM bankAccount");
	        while (rs.next()) {
	            String userID = rs.getString("UserID");
	            String name = rs.getString("Name");
	            int balance = rs.getInt("Balance");
	            int freeze = 0;
	            try {
	                freeze = rs.getInt("Freeze");
	            } catch (Exception e) {
	            	System.out.println(e);
	            }
	            BankAccountDTO dto = new BankAccountDTO(userID, name, balance, freeze);
	            users.add(dto);
	        }
	        System.out.println("Found All and Stored in table Object Successfully");
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }	    
	    return users;
	}
	
	@Override
	public BankAccountDTO findByPrimaryKey(String UserId) {	
		try {
			PreparedStatement ps=con.prepareStatement("Select * From bankAccount where UserID=?");
			ps.setString(1, UserId);
			ResultSet rs=ps.executeQuery();
//			if (rs.next()) {
//	            String userID = rs.getString("UserID");
//	            String name = rs.getString("Name");
//	            int balance = rs.getInt("Balance");
//	            int freeze = 0;
//	            try {
//	                freeze = rs.getInt("Freeze");
//	            } catch (Exception e) {
//	            	System.out.println(e);
//	            }
//	            dto = new BankAccountDTO(userID, name, balance, freeze); 
//			}
			
			return Optional.ofNullable(rs)
			.filter(new MyPred())
			.map(new MYFunc())
			.orElse(null);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			return null;
		}
		
	}
	class MYFunc implements Function<ResultSet, BankAccountDTO>{
		@Override
		public BankAccountDTO apply(ResultSet t) {
			// TODO Auto-generated method stub
			BankAccountDTO dto=null;
			try {
				dto=new BankAccountDTO(t.getString("UserID"),t.getString("Name"),t.getInt("Balance"),t.getInt("Freeze"));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			return dto;
		}
	}
	class MyPred implements Predicate<ResultSet>{
		@Override
		public boolean test(ResultSet t)  {
			// TODO Auto-generated method stub
			boolean a=false;
			try {
				a=t.next();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			return a;
		}
	}
	
	@Override
	public void delete(BankAccountDTO dto) throws Exception {
		// TODO Auto-generated method stub	
		PreparedStatement ps=con.prepareStatement("Delete from bankAccount where UserID=?");
		ps.setString(1,dto.getUserID());
		ps.execute();
	}
	
	@Override
	public void save(BankAccountDTO dto) throws Exception {
		// TODO Auto-generated method stub	
		PreparedStatement ps=con.prepareStatement("Insert into bankAccount values(?,?,?,?)");
		ps.setString(2,dto.getName());
		ps.setInt(3, dto.getBalance());
		ps.setInt(4, dto.getFreeze());
		ps.setString(1,dto.getUserID());
		ps.execute();
	}
	
	@Override
	public void update(BankAccountDTO dto)  throws Exception{
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement("Update bankAccount set Name=?,Balance=?,Freeze=? where UserID=? ");
		ps.setString(1,dto.getName());
		ps.setInt(2, dto.getBalance());
		ps.setInt(3, dto.getFreeze());
		ps.setString(4,dto.getUserID());
		ps.execute();
	}
}