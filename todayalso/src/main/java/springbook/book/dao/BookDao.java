package springbook.book.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springbook.book.model.Book;
import springbook.book.model.BookStatus;


@Repository// this does lot of other things
public class BookDao {

	private JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
	public BookDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("jdbc template wired in dao");
	}

	public boolean updateBookInDB(Book updatedBook) {
		// TODO Auto-generated method stub
		boolean updated=false;
		String sql ="update book1table set book_name=?,price=? where book_id=?";
		
		Object[] rarams= {updatedBook.getBook_name(),updatedBook.getPrice(),updatedBook.getBook_id()};
		int ra =jdbcTemplate.update(sql,rarams);//
		if(ra > 0)
				updated=true;
		
		return updated;
	}
	
	
	

	public BookStatus getBookDetailsFromDb(int bookId) {
		// TODO Auto-generated method stub
		BookStatus bookStatus =new BookStatus(-1,"booknotfound",null);
		String sql ="select book_id, book_name, price from book1table where book_id=?";
		
		Object params[]= {bookId};
		BeanPropertyRowMapper<Book> brm
		=new BeanPropertyRowMapper<Book>(Book.class);
		Book book=null;
		try {
			book = jdbcTemplate.queryForObject(sql, params,brm);
			bookStatus.setStatusCode(1);
			bookStatus.setMessage("book details found");
			bookStatus.setBook(book);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("when bookid is not found in where condition");
		}
				
		return bookStatus;
	}

	public List<Book> getAllBooksLessthanPriceFromDb(int price) {
		// TODO Auto-generated method stub
		List<Book> books =new ArrayList<Book>();
		String sql ="select book_id, book_name, price from book1table where price < ?";
		
		Object params[]= {price};
		BeanPropertyRowMapper<Book> brm
		=new BeanPropertyRowMapper<Book>(Book.class);
		try {
			books = jdbcTemplate.query(sql, params,brm);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("when bookid is not found in where condition");
		}
		
		return books;
	}

}
