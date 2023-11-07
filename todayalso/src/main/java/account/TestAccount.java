package account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import account.model.Account;
import account.model.AccountStatus;
import account.service.AccountService;

@SpringBootApplication
public class TestAccount implements CommandLineRunner{

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TestAccount.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Account updatedAccount = new Account(112,100,30,"abc",false);
		boolean updatedStatus = accountService.updateAccount(updatedAccount);
		if(updatedStatus)
			System.out.println("account updated");
		else
			System.out.println("account not updated");
				
		/*
		int accountNo =23;
		AccountStatus accountStatus=accountService.getAccountDetails(accountNo);
		if(accountStatus.getAccountStatusCode() == 0)
			System.out.println("account details not found");
		else
			System.out.println("account details found" + accountStatus.getAccount());
		*/
		
		
		
		
	}

}
