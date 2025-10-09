package DTADAO;

import java.io.Serializable;

public class BankAccountDTO implements Serializable,Cloneable,Comparable<BankAccountDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2840737377210190603L;
	String UserID,Name;
	int Balance,Freeze;
	
	
	
	public BankAccountDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BankAccountDTO(String UserID,String Name,int Balance,int Freeze) {
		// TODO Auto-generated constructor stub
		setUserID(UserID);
		setName(Name);
		setBalance(Balance);
		setFreeze(Freeze);
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public int getFreeze() {
		return Freeze;
	}

	public void setFreeze(int freeze) {
		Freeze = freeze;
	}
	
	@Override
	public int compareTo(BankAccountDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}
