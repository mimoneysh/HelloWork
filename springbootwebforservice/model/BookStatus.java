package springbook.book.model;

public class BookStatus {
	
	private int statusCode;
	private String message;
	private Book book;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookStatus(int statusCode, String message, Book book) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.book = book;
	}
	public BookStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
