package Ecertificates.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import Ecertificates.model.Cert;
import Ecertificates.model.CertStatus;

@Repository
public class CertDao {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public CertDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate= jdbcTemplate;
		System.out.println("JDBC DAO connected successfully!");
	}
	public CertStatus getCertDetailsFromDb(String sNo) {
		CertStatus certStatus=new CertStatus(-1, "CertNotFound", null);
		String query ="SELECT * FROM Ecertificate where serialNumber = ?";
		
		Object params[]= {sNo};
		BeanPropertyRowMapper<Cert> brm
		=new BeanPropertyRowMapper<Cert>(Cert.class);
		Cert cert=null;
		try {
			cert = jdbcTemplate.queryForObject(query, params,brm);
			certStatus.setStatusCode(1);
			certStatus.setMessage("E-certificate details found!");
			certStatus.setCert(cert);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("serial no is not found !");
		}
				
		return certStatus;
		
	}
	
	
	public List<Cert> getAllCertInDb() {
		// TODO Auto-generated method stub
		List<Cert> certs=new ArrayList<Cert>();
		String query = "SELECT * FROM Ecertificate";
		
		Object params[]= {};
		BeanPropertyRowMapper<Cert> brm 
		=new BeanPropertyRowMapper<Cert>(Cert.class);
		
		try {
			certs = jdbcTemplate.query(query, params, brm);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("No Certificates Available!");
		}
		
			return certs;
	}
	
	public boolean createCertInDb(Cert newCert) {
		// TODO Auto-generated method stub
		boolean created=false;
		String query = "INSERT INTO Ecertificate (serialNumber, Email, CN, C, O, OU, telephoneNumber, ST, SignatureAlgorithm, SignatureParameters, Signature) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		  Object[] param={newCert.getSerialNumber(),newCert.getEmail(),newCert.getCN(),newCert.getC(),newCert.getO(),newCert.getOU(),newCert.getTelephoneNumber(),newCert.getST(),newCert.getSignatureAlgorithm(),newCert.getSignatureParameters(),newCert.getSignature()}; 
		  for (Object value : param) { 
			  System.out.println(value);
			  }
		 
		
		
		//String dummy = objectMapper.writeValueAsString(data);

			
				try {
					int ra = jdbcTemplate.update(query, newCert.getSerialNumber(),newCert.getEmail(),newCert.getCN(),newCert.getC(),newCert.getO(),newCert.getOU(),newCert.getTelephoneNumber(),newCert.getST(),newCert.getSignatureAlgorithm(),newCert.getSignatureParameters(),newCert.getSignature());
					if (ra > 0)
						created = true;
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			
				
			
		return created;
	}
	
	
	public boolean deleteCertInDb(String sNo) {
		// TODO Auto-generated method stub
		
		boolean deleted=false;
		String query="delete from Ecertificate where serialNumber=?";
		
		Object[] param= {sNo};
		
		int ra=jdbcTemplate.update(query, param);
		
		if(ra>0)
			deleted=true;
		
		return deleted;
	}
	

	public boolean updateCertInDb(Cert updatedCert) {
		// TODO Auto-generated method stub
		boolean updated=false;
		String query="update Ecertificate SET  Email=?, CN=?, C=?, O=?, OU=?, telephoneNumber=?, ST=?, SignatureAlgorithm=?, SignatureParameters=?, Signature=? WHERE serialNumber=?";
		/*
		 * Object[] param=
		 * {updatedCert.getSerialNumber(),updatedCert.getEmail(),updatedCert.getCN(),
		 * updatedCert.getC(),updatedCert.getO(),updatedCert.getOU(),updatedCert.
		 * getTelephoneNumber(),updatedCert.getST(),updatedCert.getSignatureAlgorithm(),
		 * updatedCert.getSignatureParameters(),updatedCert.getSignature()}; for (Object
		 * value : param) { System.out.println(value); }
		 */
		int ra=jdbcTemplate.update(query,updatedCert.getEmail(),updatedCert.getCN(),updatedCert.getC(),updatedCert.getO(),updatedCert.getOU(),updatedCert.getTelephoneNumber(),updatedCert.getST(),updatedCert.getSignatureAlgorithm(),updatedCert.getSignatureParameters(),updatedCert.getSignature(), updatedCert.getSerialNumber());
		
		if (ra>0)
			updated=true;
		return updated;
	}

}
