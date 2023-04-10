package edu.humber.traffic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	List<Vehicle> findByDriver(Driver driver);
}
