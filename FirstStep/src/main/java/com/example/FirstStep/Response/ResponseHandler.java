package com.example.FirstStep.Response;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    
	public static ResponseEntity<Object> responseBuilder(String message,HttpStatus httpStatus, Object obj){
	
		Map<String, Object> response = new HashMap<>();
		response.put("message",message);
		response.put("httpStatus",httpStatus);
		response.put("data",obj);
		
		return new ResponseEntity<>(response,httpStatus);
	}
}
