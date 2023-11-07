package springbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.xdevapi.Table;

import springbook.book.model.Book;
import springbook.book.model.BookStatus;
import springbook.book.service.BookService;

//focus on controller is only on how to get input, does output reach the client
//as response.. that's it..

@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	@PostMapping("/createbook")
	public boolean createbook(@RequestBody Book createdBook) {
		// TODO Auto-generated method stub
		System.out.println("input is" + createdBook);
		return bookService.createBook(createdBook);
	}
	
	@PutMapping("/updatebook")
	public boolean updateBook(@RequestBody Book updatedBook) {
		// TODO Auto-generated method stub
		System.out.println("input is" + updatedBook);
		return bookService.updateBook(updatedBook);
	}

	@GetMapping("/gbd/{bookId}")
	public BookStatus getBookDetails(@PathVariable int bookId) {
		// TODO Auto-generated method stub
		
		return bookService.getBookDetails(bookId);
	}

	@GetMapping("/gblp")
	public List<Book> getBooksLessthanPrice(@RequestParam Float price) {
		// TODO these things we should  not show  laziness

		return bookService.getBooksLessthanPrice(price);
	}
	
	@GetMapping("/list")
	public List<Book> getAllBooks(){
		
		return bookService.getAllBooks();
	}
	
	@GetMapping("/del/{bookId}")
	public boolean deleteBook(@PathVariable int bookId) {
		// TODO Auto-generated method stub
		System.out.println("input is" + bookId);
		return bookService.deleteBook(bookId);
	}
	
	
	
	

}





