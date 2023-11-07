package account.model;

public class Account {
	
	private int acno;
	private int pin;
	private int balance;
	private String email;
	private boolean blocked;
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public Account(int acno, int pin, int balance, String email, boolean blocked) {
		super();
		this.acno = acno;
		this.pin = pin;
		this.balance = balance;
		this.email = email;
		this.blocked = blocked;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [acno=" + acno + ", pin=" + pin + ", balance=" + balance + ", email=" + email + ", blocked="
				+ blocked + "]";
	}
	
	

}
