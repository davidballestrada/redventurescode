package com.redventures.iotdevices.repository;

import org.springframework.stereotype.Repository;

import com.redventures.iotdevices.constants.IOTConstants;
import com.redventures.iotdevices.entity.Door;
import com.redventures.iotdevices.entity.Employee;
import com.redventures.iotdevices.entity.EmployeesAccess;

//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
//public interface EmployeesAccessRepository extends JpaRepository<EmployeesAccess, Integer> {
public class EmployeesAccessRepository {
	public EmployeesAccess findbyEmployeeAndDoor(Employee employee, Door door) {
		
		if(IOTConstants.EMPLOYEES_ACCESS.get(employee.getId()) != null && IOTConstants.EMPLOYEES_ACCESS.get(employee.getId()).contains(door.getId())) {
			EmployeesAccess employeesAccess = new EmployeesAccess();
			
			employeesAccess.setEmployee(employee);
			employeesAccess.setDoor(door);
			
			return employeesAccess;
		} else {
			return null;
		}
	}
}
