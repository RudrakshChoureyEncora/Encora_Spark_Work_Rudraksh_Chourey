package mindGymDay1;

public class ExceptionHandling2 {

	public static void main(String[] args) {//throws LowBalanceException {
		Customer1 customer=new Customer1();
		customer.useATM(new Atm());
	}
}

//custom exception
class Customer1{
	public void useATM(Atm atm) {//throws LowBalanceException{
		System.out.println("before exception....");
		try{
			atm.withdraw(5000);
		}catch(LowBalanceException lb) {
			lb.printStackTrace();
			System.out.println(lb);
//			System.out.println(lb.getCause());
		}finally {
			System.out.println("finally called....");
		}
		System.out.println("after exception....");
	}
}
class LowBalanceException extends Exception{
	String msg;
	public LowBalanceException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
	
}

class Atm{
	int balance=1000;
	public void withdraw(int amount)throws LowBalanceException {
		if(amount>balance) {
			
			throw new LowBalanceException("your balance is low..please refill");
			
		}
	}
}









