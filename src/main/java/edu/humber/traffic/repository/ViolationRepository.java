package edu.humber.traffic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {

	List<Violation> findByDriver(Driver driver);

}
