package Ecertificates.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cert {
	
	public Cert() {
		
	}
	@Autowired
	public Cert(String serialNumber, String email, String cN, String c, String o, String oU, String telephoneNumber,
			String sT, String signatureAlgorithm, String signatureParameters, String signature) {
		super();
		this.serialNumber = serialNumber;
		Email = email;
		CN = cN;
		C = c;
		O = o;
		OU = oU;
		this.telephoneNumber = telephoneNumber;
		ST = sT;
		SignatureAlgorithm = signatureAlgorithm;
		SignatureParameters = signatureParameters;
		Signature = signature;
	}

	private String serialNumber;
	@JsonProperty("Email")
    private String Email;
	@JsonProperty("CN")
    private String CN;
	@JsonProperty("C")
    private String C;
	@JsonProperty("O")
    private String O;
	@JsonProperty("OU")
    private String OU;
	@JsonProperty("telephoneNumber")
    private String telephoneNumber;
	@JsonProperty("ST")
    private String ST;
	@JsonProperty("SignatureAlgorithm")
    private String SignatureAlgorithm;
	@JsonProperty("SignatureParameters")
    private String SignatureParameters;
	@JsonProperty("Signature")
    private String Signature;
	@JsonProperty("RowNumber")
    private String RowNumber;

    // Getters and setters for the fields

    public String getRowNumber() {
		return RowNumber;
	}
	public void setRowNumber(String rowNumber) {
		RowNumber = rowNumber;
	}
	public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEmail() {
    	
        return Email;
    }

    public void setEmail(String Email) {
    	//this.Email = "test@cdac.com";
    	//System.out.println("set email: "+Email);

        this.Email = Email;
    }

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getO() {
        return O;
    }

    public void setO(String O) {
        this.O = O;
    }

    public String getOU() {
        return OU;
    }

    public void setOU(String OU) {
        this.OU = OU;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getSignatureAlgorithm() {
        return SignatureAlgorithm;
    }

    public void setSignatureAlgorithm(String SignatureAlgorithm) {
        this.SignatureAlgorithm = SignatureAlgorithm;
    }

    public String getSignatureParameters() {
        return SignatureParameters;
    }

    public void setSignatureParameters(String SignatureParameters) {
        this.SignatureParameters = SignatureParameters;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }

}
