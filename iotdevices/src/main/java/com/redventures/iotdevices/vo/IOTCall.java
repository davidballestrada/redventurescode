package com.redventures.iotdevices.vo;

import lombok.Data;

@Data
public class IOTCall {
	private String id;
	private String event;
	private Payload payload;
}
