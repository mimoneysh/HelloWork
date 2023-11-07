package springbook.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springbook.book.dao.BookDao;
import springbook.book.model.Book;
import springbook.book.model.BookStatus;



@Service
public class BookService {
	
	private BookDao bookDao ;
	
	
	

	
	@Autowired
	public BookService(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
		System.out.println("dao wired in service");
	}

	public boolean updateBook(Book updatedBook) {
		// TODO Auto-generated method stub
		return bookDao.updateBookInDB(updatedBook);
	}

	public BookStatus getBookDetails(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.getBookDetailsFromDb(bookId);
	}

	public List<Book> getBooksLessthanPrice(Float price) {
		// TODO Auto-generated method stub
		return bookDao.getAllBooksLessthanPriceFromDb(price);
	}

	public boolean createBook(Book createdBook) {
		// TODO Auto-generated method stub
		return bookDao.createBookInDB(createdBook);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooksInDb();
	}

	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookInDB(bookId);
	}

}
