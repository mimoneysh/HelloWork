package DemoLogin.Model;

public class UserStatus {
	
	private int StatusCode;
	private String Message;
	private User user;
	public UserStatus(int statusCode, String mesage, User user) {
		super();
		this.StatusCode = statusCode;
		this.Message = mesage;
		this.user = user;
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		this.StatusCode = statusCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String mesage) {
		this.Message = mesage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

	

	

	

}
