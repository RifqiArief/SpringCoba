package co.id.latihan.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.id.latihan.backend.model.Transaction;
import co.id.latihan.backend.rest.BaseResponse;
import co.id.latihan.backend.rest.TransactionRequest;
import co.id.latihan.backend.rest.TransactionSumResponse;
import co.id.latihan.backend.rest.TrxReqCreate;
import co.id.latihan.backend.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService trService;
	
	@GetMapping (value = "/transactionservice/transaction/{id}")
	public Transaction getTransactionById(@PathVariable Long id) {
		
		return trService.getTransactionById(id);
		
	}
	
	@GetMapping (value = "/transactionservice/type/{type}")
	public List<Transaction> getTransactionByType(@PathVariable String type) {
		
		return trService.getTransactionByType(type);
		
	}
	
	@GetMapping (value = "/transactionservice/sum/{parentId}")
	public TransactionSumResponse sumByParentId(@PathVariable Long parentId) {
		
		TransactionSumResponse resp = new TransactionSumResponse();
		resp.setSum(trService.sumById(parentId));
		
		return resp;
		
	}
	
	@PutMapping (value = "/transactionservice/transaction/{id}")
	public BaseResponse createTransaction(@RequestBody TrxReqCreate request, @PathVariable Long id) {
		BaseResponse resp = trService.createTransaction(request, id);
		return resp;
	}
}
