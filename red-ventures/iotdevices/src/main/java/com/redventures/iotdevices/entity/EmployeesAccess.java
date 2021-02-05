package com.redventures.iotdevices.entity;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
//@Entity
//@Table(name = "EmployeesAccess")
public class EmployeesAccess implements Serializable {
	private static final long serialVersionUID = -1580351399670825620L;
//	@Id
//	@Column(name = "id")
	private Employee employee;
//	@Column(name = "idDoor")
	private Door door;
}
