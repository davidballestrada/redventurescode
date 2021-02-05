package com.redventures.iotdevices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redventures.iotdevices.service.EmployeeValidation;
import com.redventures.iotdevices.vo.IOTAutorization;
import com.redventures.iotdevices.vo.IOTCall;

@RestController
@RequestMapping(path = "/iotDevice")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class IOTController {
	@Autowired
	EmployeeValidation employeeValidation;
	
	Logger logger = LoggerFactory.getLogger(IOTController.class);
	
	@PostMapping("validateIOT")
	public ResponseEntity<Object> validateIOT(@RequestBody IOTCall iOTCall, @RequestHeader(value="IOTDeviceID") Integer iOTDeviceId) {
		IOTAutorization iOTAutorization;
		
		try {
			if(!employeeValidation.isRequestValid(iOTCall, iOTDeviceId)) {
				logger.error("Bad request for " + iOTCall.toString());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The request is invalid");
			}
			
			iOTAutorization = employeeValidation.validateIOT(iOTCall, iOTDeviceId);
			
			logger.info("Access granted for " + iOTCall.toString());
			return ResponseEntity.status(HttpStatus.OK).body(iOTAutorization);
		} catch (Exception e) {
			logger.error("Unespected server error for " + iOTCall.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inespected error in the server...");
		}
	}
}
