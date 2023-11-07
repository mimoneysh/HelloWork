package Ecertificates.controller;

import java.security.PublicKey;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Ecertificates.model.Cert;
import Ecertificates.model.CertStatus;
import Ecertificates.service.CertService;





@Controller
//@RestController
public class CertController {
	
	@Autowired
	private CertService certService;
	private static final Logger logger = LoggerFactory.getLogger(CertController.class);
	
	
	  @GetMapping("/") 
	  public String renderPage() { 
		  return "index"; 
		  }
	 
	
	
	@GetMapping("/getCert/{sNo}")
	@ResponseBody
	public CertStatus getCertDetails(@PathVariable String sNo) {
		
		return certService.getCertDetails(sNo);
	}
	
	@GetMapping("/delCert/{sNo}")
	@ResponseBody
	public boolean deleteCert(@PathVariable String sNo) {
		
		return certService.deleteCert(sNo);
	}
	
	@PutMapping("/updateCert")
	@ResponseBody
	public boolean updateCert(@RequestBody Cert updatedCert){
	
		return certService.updateCert(updatedCert);
	
	}
	
	
	
	@GetMapping("/list")
	@ResponseBody
	public List<Cert> getAllCert(){
		return certService.getAllCert();
	}
	
	
	
	@PostMapping("/createCert")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	 public boolean createCert(@RequestBody Cert newCert) {
		logger.info("Received JSON data: " + newCert);
		
		logger.info("Serial Number: " + newCert.getSerialNumber());
	    logger.info("Email: " + newCert.getEmail());
	    logger.info("common name: " + newCert.getCN());
	    logger.info("Country: " + newCert.getC());
	    logger.info("Organization unit: " + newCert.getOU());
	    logger.info("Organization: " + newCert.getO());
	    logger.info("telephoneNumber: " + newCert.getTelephoneNumber());
	    logger.info("State: " + newCert.getST());
	    logger.info("SignatureAlgorithm: " + newCert.getSignatureAlgorithm());
	    logger.info("SignatureParameters: " + newCert.getSignatureParameters());
	    logger.info("Signature: " + newCert.getSignature());

//		System.out.println("Cert Input : "+ createdCert);		
//		System.out.println("Serial Number: " + createdCert.getSerialNumber());
	    //System.out.println("Email: " + createdCert.getEmail());
		
		
		//return certService.createCert(createdCert);
	    
	    
	    logger.info("Received Cert Data: " + newCert.toString());
	    
	    return certService.createCert(newCert);
		
	}

	
	
	
	
	

}
