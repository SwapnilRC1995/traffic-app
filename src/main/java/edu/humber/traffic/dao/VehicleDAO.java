package edu.humber.traffic.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.Vehicle;
import edu.humber.traffic.repository.VehicleRepository;

@Component
public class VehicleDAO {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicleByDriver(Driver driver) {
		try {
			return vehicleRepository.findByDriver(driver);
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	public Vehicle getVehicleById(String id) {
		try {
			return vehicleRepository.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	public String createVehicle(Vehicle vehicle) {
		return vehicleRepository.saveAndFlush(vehicle).getVehicleId();
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
}
