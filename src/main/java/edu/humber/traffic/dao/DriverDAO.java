package edu.humber.traffic.dao;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.repository.DriverRepository;

@Component
public class DriverDAO {

	@Autowired
	private DriverRepository driverRepository;

	public Driver getDriverByLicenseNumber(int licenseNumber) {
		try {
			return driverRepository.findById(licenseNumber).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
}
