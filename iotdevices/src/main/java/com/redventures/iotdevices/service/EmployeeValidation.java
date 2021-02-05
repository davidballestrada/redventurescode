package com.redventures.iotdevices.service;

import com.redventures.iotdevices.vo.IOTAutorization;
import com.redventures.iotdevices.vo.IOTCall;

public interface EmployeeValidation {
	public IOTAutorization validateIOT(IOTCall iOTCall, Integer iOTDeviceId);
	public boolean isRequestValid(IOTCall iOTCall, Integer iOTDeviceId);
}
