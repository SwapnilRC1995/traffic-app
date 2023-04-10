package edu.humber.traffic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.humber.traffic.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
