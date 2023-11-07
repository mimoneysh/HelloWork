package springbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springbook.book.model.Book;
import springbook.book.model.BookStatus;

//focus on controller is only on how to get input, does output reach the client
//as response.. that's it..

@RestController
public class BookController {
	
	@PutMapping("/updatebook")
	public boolean updateBook(@RequestBody Book updatedBook) {
		// TODO Auto-generated method stub
		System.out.println("input is" + updatedBook);
		return true;
	}

	@GetMapping("/gbd/{bookId}")
	public BookStatus getBookDetails(@PathVariable int bookId) {
		// TODO Auto-generated method stub
		BookStatus bookStatus =new BookStatus(-1,"booknotfound",null);
		System.out.println("book id " +bookId);
		return bookStatus;
	}

	@GetMapping("/gbd")
	public List<Book> getBooksLessthanPrice(@RequestParam int price) {
		// TODO these things we shoud  not show  laziness

		System.out.println("input is price" +price);
		List<Book> books =new ArrayList<Book>();
		books.add(new Book(1,"X",3));
		return books;
	}

}
