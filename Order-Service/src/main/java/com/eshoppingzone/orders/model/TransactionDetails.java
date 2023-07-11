package com.eshoppingzone.orders.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Transactions")
public class TransactionDetails {
	
	private String orderId;
	private String currency;
	private Integer amount;
	private String key;

}
