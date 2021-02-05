package com.redventures.iotdevices.vo;

import lombok.Data;

@Data
public class IOTAutorization {
	private String idRequest;
	private boolean access;
	private String message;
}
