package co.id.latihan.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.id.latihan.backend.model.Transaction;
import co.id.latihan.backend.rest.TransactionRequest;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{
	
	Transaction findByTrxId(Long id);
	List<Transaction> findByType(String type);
	
}
