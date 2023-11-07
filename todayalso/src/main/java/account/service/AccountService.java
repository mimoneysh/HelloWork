package account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import account.dao.AccountDAO;
import account.model.Account;
import account.model.AccountStatus;

//service functiond esign needs patience.. becusae we cannot copy paste from google.
@Service
public class AccountService {
//think what is input
	//what is output
	//how will we know success or failure.
	
	@Autowired
	private AccountDAO accountDao;
	
	
	
	
	public AccountStatus getAccountDetails(int accountNo) {
		// TODO Auto-generated method stub
		//System.out.println("input is"+ accountNo);
		AccountStatus accountStatus =new AccountStatus(1, "Abc",new Account(1,-1,-1,"",false));
		return accountDao.getAccountDetailsFromDB(accountNo);
	}

	public boolean updateAccount(Account updatedAccount) {
		// TODO Auto-generated method stub
		//System.out.println("input " + updatedAccount);
		return accountDao.updateAccountInDb(updatedAccount);
	}

}
