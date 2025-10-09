package DTADAO;

public class TestingDTODAO {
	public static void main(String[] args) throws Exception{
		BankAccountDAOImpl dao=new BankAccountDAOImpl();
		dao.setCon(ConnectionUtility.getConnection());
		
		try {
			String crid="U011";
			String drid="U022";
			int amt=100;
			
			BankAccountDTO creditor=dao.findByPrimaryKey(crid);
			int available=creditor.getBalance();
			if(available<amt) {
				throw new InsufficientBalanceException(amt-available);
			}
			else {
				int x=creditor.getBalance()-amt;
				creditor.setBalance(x);
				dao.update(creditor);//credited
				
				BankAccountDTO debtor=dao.findByPrimaryKey(drid);
				x=debtor.getBalance()+amt;
				dao.update(debtor);
			}
			
			dao.save(new BankAccountDTO("U033","Rudraksh",2000,0));
			dao.delete(new BankAccountDTO("U033","Rudraksh",2000,0));
			ConnectionUtility.closeConnection(null, null);
			
			
			
		} catch (Exception e) {
			try {
				e.printStackTrace();
				ConnectionUtility.closeConnection(e, null);
			}catch(Exception ee) {ee.printStackTrace();}
		}
	}
}

class InsufficientBalanceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int diff;
	public InsufficientBalanceException(int diff) {
		// TODO Auto-generated constructor stub
		this.diff=diff;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Insufficient by "+diff;
	}
}