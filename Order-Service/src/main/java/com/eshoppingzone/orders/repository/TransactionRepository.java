package com.eshoppingzone.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.eshoppingzone.orders.model.TransactionDetails;

public interface TransactionRepository extends MongoRepository<TransactionDetails, Integer>{
	
	
	

}
