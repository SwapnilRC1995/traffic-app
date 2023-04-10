package edu.humber.traffic.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	private String vehicleId;
	private String brand;
	private String type;
	private Driver driver;

	@Id
	@Column(name = "VEHICLE_ID")
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "BRAND")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToOne(targetEntity = Driver.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "DRIVER_ID", referencedColumnName = "LICENSE_NUMBER")
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
