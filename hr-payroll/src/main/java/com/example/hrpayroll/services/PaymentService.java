package com.example.hrpayroll.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	//faz a conexão entre dois ou mais projetos existentes no caso o worker
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	/*
	 pega o pagamento construido no hr-payroll e busca através do feignclient o id e nome do trabalhador
	 	
	*/
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody(); 
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
