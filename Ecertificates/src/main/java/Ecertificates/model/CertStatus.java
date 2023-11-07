package Ecertificates.model;



public class CertStatus {
	
	private int statusCode;
	private String message;
	private Cert cert;
	public CertStatus(int statusCode, String message, Cert cert) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.cert = cert;
	}
	
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
	public Cert getCert() {
		return cert;
	}
	public void setCert(Cert cert) {
		this.cert = cert;
	}

}
