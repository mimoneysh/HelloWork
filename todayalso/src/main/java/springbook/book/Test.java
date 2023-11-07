package springbook.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pleaeswork.todayalso.TodayalsoApplication;
import springbook.book.model.Book;
import springbook.book.model.BookStatus;
import springbook.book.service.BookService;

@SpringBootApplication
public class Test  implements CommandLineRunner
{
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
		System.out.println("dedicated to the kid");
		
	}
	
	@Autowired
private BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//main4(null);
		
	}
	
	
	
	
	
	
	public  void main4(String[] args) {
	
		
		int price =10;
		// want to get all books less than this price
		List<Book> books = bookService.getBooksLessthanPrice(price);
		if(books.isEmpty())
			System.out.println("no books found less than that price");
		else
		{
			System.out.println("books are found we wil show");
			for(Book x: books)
			{
				System.out.println(x.getBook_name() +  "  " + x.getPrice());
			}
		}
			
		
	}
	
	
	
	public  void main3(String[] args) {
		
		
		   int bookId =123; //kih
		   BookStatus bookStatus=
				   bookService.getBookDetails(bookId);
		   
		   if(bookStatus.getStatusCode() == -1)
		   {
			   System.out.println("book details not found");
		   }
		   else
		   {
			   System.out.println("book details found");
			   Book b = bookStatus.getBook();
			   System.out.println(b.getBook_name() +  "  " + b.getPrice());
		   }
		   
	
	
	
	}
	
	public  void main2(String[] args) {
		
		
		Book updatedBook =new Book(1,"def",90);//assume you
		//got this from textbox, scnner.. wherever..
		boolean bookUpdatedStatus=
				bookService.updateBook(updatedBook);
		if(bookUpdatedStatus )
			System.out.println("book updated");
		else
			System.out.println("book not updated");
		
	}

	








	
	

	

}
