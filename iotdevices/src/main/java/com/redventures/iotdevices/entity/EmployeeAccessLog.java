package com.redventures.iotdevices.entity;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
//@Entity
//@Table(name = "EmployeesAccessLog")
public class EmployeeAccessLog implements Serializable {
	private static final long serialVersionUID = 546049216008427511L;
//	@Id
//	@Column(name = "id")
	private Integer id;
//	@Column(name = "idEmployee")
	private Employee employee;
//	@Column(name = "idDoor")
	private Door door;
//	@Column(name = "idRequest")
	private String idRequest;
//	@Column(name = "accessed")
	private boolean accessed;
}
