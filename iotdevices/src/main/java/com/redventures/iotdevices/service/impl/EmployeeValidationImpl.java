package com.redventures.iotdevices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redventures.iotdevices.constants.IOTConstants;
import com.redventures.iotdevices.entity.Door;
import com.redventures.iotdevices.entity.Employee;
import com.redventures.iotdevices.entity.EmployeeAccessLog;
import com.redventures.iotdevices.repository.EmployeeAccessLogRepository;
import com.redventures.iotdevices.repository.EmployeesAccessRepository;
import com.redventures.iotdevices.service.EmployeeValidation;
import com.redventures.iotdevices.vo.IOTAutorization;
import com.redventures.iotdevices.vo.IOTCall;

@Service
public class EmployeeValidationImpl implements EmployeeValidation {

	@Autowired
	EmployeeAccessLogRepository employeeAccessLogRepository;
	
	@Autowired
	EmployeesAccessRepository employeesAccessRepository;
	
	public IOTAutorization validateIOT(IOTCall iOTCall, Integer iOTDeviceId) {
		IOTAutorization iOTAutorization = new IOTAutorization();
		
		iOTAutorization.setIdRequest(iOTCall.getId());
		Employee employee = new Employee();
		employee.setId(iOTCall.getPayload().getEmployeeId());
		
		Door door = new Door();
		door.setId(iOTDeviceId);
		
		if(employeesAccessRepository.findbyEmployeeAndDoor(employee, door) != null) {
			iOTAutorization.setAccess(true);
			iOTAutorization.setMessage("Access granted for Employee ID: " + iOTCall.getPayload().getEmployeeId());

		} else {
			iOTAutorization.setAccess(false);
			iOTAutorization.setMessage("Access denied for Employee ID: " + iOTCall.getPayload().getEmployeeId());

		}
		
		saveAccessLog(iOTCall, iOTDeviceId, iOTAutorization);
		
		return iOTAutorization;
	}
	
	public boolean isRequestValid(IOTCall iOTCall, Integer iOTDeviceId) {
		try {
			if(iOTCall.getPayload().getEmployeeId() < 1) {
				return false;
			}
			
			if(!IOTConstants.DOORS.contains(iOTDeviceId)) {
				return false;
			}
			
			if(!IOTConstants.EVENTS.contains(iOTCall.getEvent())) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void saveAccessLog(IOTCall iOTCall, Integer iOTDeviceId, IOTAutorization iOTAutorization) {
		Door door = new Door();
		door.setId(iOTDeviceId);
		
		Employee employee = new Employee();
		employee.setId(iOTCall.getPayload().getEmployeeId());
		
		EmployeeAccessLog employeeAccessLog = new EmployeeAccessLog();
		
		employeeAccessLog.setDoor(door);
		employeeAccessLog.setEmployee(employee);
		employeeAccessLog.setIdRequest(iOTCall.getId());
		employeeAccessLog.setAccessed(iOTAutorization.isAccess());
		
		employeeAccessLogRepository.save(employeeAccessLog);
	}
}
