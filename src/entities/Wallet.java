package entities;

public class Wallet {
	private String mobileNo;
	private String name;
	private int balance;
	
	public Wallet() {
	}
	
	public Wallet(String mobile, String name, int balance) {
		this.mobileNo=mobile;
		this.name=name;
		this.balance=balance;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	} 

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void addBalance(int balance) {
		this.balance+=balance;
	}
	
	
	
	@Override
	public String toString() {
		String display = this.mobileNo+" "+this.name+" "+this.balance;
		return display;
	} 
	
}
