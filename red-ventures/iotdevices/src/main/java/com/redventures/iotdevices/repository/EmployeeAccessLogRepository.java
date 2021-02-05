package com.redventures.iotdevices.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redventures.iotdevices.entity.EmployeeAccessLog;

@Repository
//public interface EmployeeAccessLogRepository extends JpaRepository<EmployeeAccessLog, Integer> {
public class EmployeeAccessLogRepository {
	Logger logger = LoggerFactory.getLogger(EmployeeAccessLogRepository.class);
	
	public void save(EmployeeAccessLog employeeAccessLog) {
		try {
			Files.write(Paths.get("EmployeeAccessLog.txt"), (employeeAccessLog.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
			logger.error("Error trying to save access log...");
		}
	}
}
