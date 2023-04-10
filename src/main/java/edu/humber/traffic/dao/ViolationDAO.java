package edu.humber.traffic.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.Violation;
import edu.humber.traffic.repository.ViolationRepository;

@Component
public class ViolationDAO {

	@Autowired
	private ViolationRepository violationRepository;

	public List<Violation> getAllViolations(Driver driver) {
		try {
			return violationRepository.findByDriver(driver);
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	public int createViolation(Violation violation) {
		return violationRepository.saveAndFlush(violation).getNoticeNumber();
	}

}
