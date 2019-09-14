package co.id.latihan.backend.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.id.latihan.backend.model.Transaction;
import co.id.latihan.backend.repository.TransactionRepo;
import co.id.latihan.backend.rest.BaseResponse;
import co.id.latihan.backend.rest.TransactionRequest;
import co.id.latihan.backend.rest.TrxReqCreate;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepo trRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	public Transaction getTransactionById(Long id) {
		
		return trRepo.findByTrxId(id);
	}
	
	public List<Transaction> getTransactionByType(String type) {
	
		return trRepo.findByType(type);
	}

	public Double sumById(Long id) {
		
		Query jpql = em.createQuery("SELECT SUM(t.amount) FROM Transaction t WHERE t.trxId = :trxId OR t.parentId = :trxId");
		jpql.setParameter("trxId", id);
		
		Double result = (Double) jpql.getSingleResult();
		return result;
	}
	
	public BaseResponse createTransaction(TrxReqCreate request, Long id) {
		BaseResponse resp = new BaseResponse();
		resp.makeSuccess("Transaction Created");
		
		Transaction trans = new Transaction();
		trans.setAmount(request.getAmount());
		trans.setParentId(request.getParentId());
		trans.setTrxId(id);
		trans.setType(request.getType());
		trRepo.save(trans);
		
		return resp;
	}
}
