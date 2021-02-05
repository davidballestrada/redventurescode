package com.redventures.iotdevices.entity;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
//@Entity
//@Table(name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name = "id")
	private Integer id;
//	@Column(name = "name")
	private String name;
}
