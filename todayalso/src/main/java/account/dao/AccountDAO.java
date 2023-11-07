package account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import account.model.Account;
import account.model.AccountStatus;
import springbook.book.model.Book;

@Repository
public class AccountDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AccountStatus getAccountDetailsFromDB(int accountNo) {
		// TODO Auto-generated method stub
		
		System.out.println(jdbcTemplate != null  ?"jdbc template not null":"null");
		AccountStatus accountStatus =new AccountStatus
				(1, "Abc",new Account(1,-1,-1,"",false));
		
String sql ="select acno, pin, balance,email, blocked from account where acno=?";
		
		Object params[]= {accountNo};
		BeanPropertyRowMapper<Account> brm
		=new BeanPropertyRowMapper<Account>(Account.class);
		Account account=null;
		try {
			account = jdbcTemplate.queryForObject(sql, params,brm);
			accountStatus.setAccountStatusCode(1);
			accountStatus.setMessage("book details found");
			accountStatus.setAccount(account);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("when bookid is not found in where condition");
		}
		
		
		
		
		
		
		System.out.println("ok in dao");
		return accountStatus;
	}

	public boolean updateAccountInDb(Account updatedAccount) {
		// TODO Auto-generated method stub
		System.out.println(jdbcTemplate != null  ?"jdbc template not null":"null");
		System.out.println("updatedAccount" + updatedAccount);
		
String sql ="update account set pin=?,balance=?,email=? where acno=?";
		
		Object[] rarams= { updatedAccount.getPin(),
					updatedAccount.getBalance(),updatedAccount.getEmail(),
					updatedAccount.getAcno()};
		int ra =jdbcTemplate.update(sql,rarams);//
		boolean updated=false;
		if(ra > 0)
				updated=true;
		return updated;
	}

}
