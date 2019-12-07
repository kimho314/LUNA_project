package day06;

public class TestMain3 {
	public static void main(String[] args) {
		ATM atm1 = new ATM();
		
		atm1.setBalance(1000000);
		atm1.deposit(5000);
		//System.out.println(atm1.balance);
		
		atm1.withdraw(10000);
		//System.out.println(atm1.balance);
	}
}
