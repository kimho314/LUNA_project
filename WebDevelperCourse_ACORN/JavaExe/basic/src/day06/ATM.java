package day06;

public class ATM {
	// 맴버 변수에는 직접겁근 금지
	// access modifier : 접근지정자, 접근하정자
	private int balance;
	private String name;
	private String accountNo;
	
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	ATM()
	{
		balance = 0;
		name = "none";
		accountNo = "none";
	}
	
	ATM(int balance, String name, String accountNo)
	{
		this.balance = balance;
		this.name = name;
		this.accountNo = accountNo;
	}
	
	ATM(ATM a)
	{
		this.balance = a.balance;
		this.name = a.name;
		this.accountNo = a.accountNo;
	}
	
	// a원 만큼 입금
	void deposit(int a)
	{		
		balance += a;		
		System.out.println(a + "원 만큼 입급합니다. " + "현재 잔액 : " + balance);
	}
	
	// a원만큼 출금
	void withdraw(int a)
	{
		if(a > balance)
		{
			System.out.println("현재 잔액이 부족합니다." + "현재 잔액 : " + balance);
		}
		else
		{
			balance -= a;
			System.out.println(a + "원 만큼 출금합니다. " + "현재 잔액 : " + balance);
		}
	}
}
