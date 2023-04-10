package edu.humber.traffic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.User;
import edu.humber.traffic.repository.UserRepository;

@Component
public class UserDAO {

	@Autowired
	private UserRepository userRepository;

	public User getUser(String username) {
		try {
			return userRepository.findById(username).get();
		} catch (NoSuchElementException ex) {
			return null;
		}

	}

	public String createUser(User user) {
		return userRepository.saveAndFlush(user).getUsername();
	}

	public List<Driver> getAllUsers() {
		List<Driver> drivers = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			drivers.add(user.getDriver());
		}
		return drivers;
	}
}
