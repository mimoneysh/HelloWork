package book.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import book.model.Book;
import book.model.BookStatus;

@RestController
public class BookController {
	
	//service is telling take a list of books and return a set of titles in the book. 

	// why did you write this.. anwer service told write this..
	
	@GetMapping("/doubt")
	public List<Book> f1()
	{
		List<Book> books =new ArrayList<Book>();
		books.add(new Book(1,"x",3));
		books.add(new Book(2,"y",4));
		return books;
		
	}
	

	@PostMapping("/gettingstruck")
	public Set<String> whocaresbutwewrotebecauseservicetoldwriteit(@RequestBody List<Book> books)
	{
		Set<String> namesofBooks =new TreeSet<String>();
		namesofBooks.add("abc");
		namesofBooks.add("123");
		namesofBooks.add("rgb");
		return namesofBooks;
	}
	
	
	
	//http://localhost:7777/qb/12
	@GetMapping("/qb/{bookId}")   //qb/1
	public BookStatus getBookDetails(@PathVariable int bookId) {
		System.out.println("did i get book id" + bookId);
		BookStatus bookStatus = new BookStatus(-1, "did not findbook", new Book(-1, "no", 0));

		return bookStatus;

	}

	
	@PostMapping("/ub")
	public boolean updateBook(@RequestBody Book updatedBook) {
//we have to know Book object look in json foramt..
		
		System.out.println(updatedBook);
		return true;

	}

}
