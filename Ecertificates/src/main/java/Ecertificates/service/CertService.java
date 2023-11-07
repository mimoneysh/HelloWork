package Ecertificates.service;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecertificates.dao.CertDao;
import Ecertificates.model.Cert;
import Ecertificates.model.CertStatus;
@Service
public class CertService {
	private CertDao certDao;
	@Autowired
	public CertService(CertDao certDao) {
		super();
		this.certDao=certDao;
		System.out.println("DAO Wired in Service!");
	}

	public CertStatus getCertDetails(String sNo) {
		// TODO Auto-generated method stub
		return certDao.getCertDetailsFromDb(sNo);
	}

	public List<Cert> getAllCert() {
		// TODO Auto-generated method stub
		return certDao.getAllCertInDb();
	}

	public boolean createCert(Cert newCert) {
		// TODO Auto-generated method stub
		return certDao.createCertInDb(newCert);
	}

	public boolean deleteCert(String sNo) {
		// TODO Auto-generated method stub
		return certDao.deleteCertInDb(sNo);
	}

	public boolean updateCert(Cert updatedCert) {
		// TODO Auto-generated method stub
		return certDao.updateCertInDb(updatedCert);
	}
	
	/*
	 * @Autowired public CertService CertService(CertDao certDao) { super();
	 * this.certDao=certDao; System.out.println("DAO wired in Service"); }
	 */

}
