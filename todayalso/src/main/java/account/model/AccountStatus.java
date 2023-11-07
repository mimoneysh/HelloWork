package account.model;

public class AccountStatus {
	
	private int accountStatusCode;
	private String message;
	private Account account;
	public int getAccountStatusCode() {
		return accountStatusCode;
	}
	public void setAccountStatusCode(int accountStatusCode) {
		this.accountStatusCode = accountStatusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountStatus() {
		// TODO Auto-generated constructor stub
	}
	public AccountStatus(int accountStatusCode, String message, Account account) {
		super();
		this.accountStatusCode = accountStatusCode;
		this.message = message;
		this.account = account;
	}
	

	
	
	
}
