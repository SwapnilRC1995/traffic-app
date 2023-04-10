package edu.humber.traffic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.humber.traffic.dao.DriverDAO;
import edu.humber.traffic.dao.UserDAO;
import edu.humber.traffic.dao.VehicleDAO;
import edu.humber.traffic.dao.ViolationDAO;
import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.User;
import edu.humber.traffic.entity.Vehicle;
import edu.humber.traffic.entity.Violation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class ViolationController {

	@Autowired
	private ViolationDAO violationDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private VehicleDAO vehicleDAO;

	@Autowired
	private DriverDAO driverDAO;

	@GetMapping(value = "/dashboard")
	public ModelAndView displayDashboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Driver driver = session.getAttribute("driver") != null ? (Driver) session.getAttribute("driver") : null;
		mv.addObject("violations", violationDAO.getAllViolations(driver));
		mv.setViewName("dashboard");
		return mv;
	}

	@GetMapping(value = "/admin-dashboard")
	public ModelAndView displayViolationForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<Driver> drivers = userDAO.getAllUsers();
		List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
		mv.addObject("drivers", drivers);
		mv.addObject("vehicles", vehicles);
		mv.setViewName("adminDashboard");
		return mv;
	}

	@PostMapping(value = "/admin-dashboard")
	public ModelAndView postViolationForm(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Violation violation = new Violation();
		Vehicle vehicle = vehicleDAO.getVehicleById(request.getParameter("vehicle"));
		Driver driver = driverDAO.getDriverByLicenseNumber(Integer.parseInt(request.getParameter("driver")));
		String description = request.getParameter("description");
		double fine = Double.parseDouble(request.getParameter("fine"));
		violation.setDriver(driver);
		violation.setVehicle(vehicle);
		violation.setFine(fine);
		violation.setDescription(description);
		int ticketNumber = violationDAO.createViolation(violation);
		mv.addObject("notification", "The ticket has been added with ticket number " + ticketNumber);
		mv.setViewName("adminDashboard");
		return mv;
	}
}
