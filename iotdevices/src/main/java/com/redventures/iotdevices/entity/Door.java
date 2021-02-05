package com.redventures.iotdevices.entity;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
//@Entity
//@Table(name = "Door")
public class Door implements Serializable {
	private static final long serialVersionUID = -7070623819111792595L;
//	@Id
//	@Column(name = "id")
	private Integer id;
//	@Column(name = "description")
	private String descriptionn;
}
