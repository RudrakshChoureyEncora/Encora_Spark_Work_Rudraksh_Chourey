package com.UnitTestingMockito.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	public CompletableFuture<String> sendEmailAsync(String email){
		return CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(500);
				return "email sent to "+email;
			} catch (Exception e) {
				// TODO: handle exception
				throw new IllegalStateException("Error sending email");
			}
		});
	}
}
