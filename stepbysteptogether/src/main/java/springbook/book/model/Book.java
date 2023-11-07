package springbook.book.model;

public class Book {
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	private int book_id;//same not because of compulsion
	//later on we during spring this advantageous
	private String book_name;
	private Float price;
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getBook_id() {
		return book_id;
	}
	public Book(int book_id, String book_name, Float price) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.price = price;
	}
	public Book(int book_id) {
		super();
		this.book_id = book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	

}
