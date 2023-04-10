package edu.humber.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.humber.traffic.dao.VehicleDAO;
import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.Vehicle;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class VehicleController {

	@Autowired
	private VehicleDAO vehicleDAO;

	@GetMapping(value = "/view-vehicles")
	public ModelAndView displayAllVehicles(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Driver driver = session.getAttribute("driver") != null ? (Driver) session.getAttribute("driver") : null;
		mv.addObject("vehicles", vehicleDAO.getVehicleByDriver(driver));
		mv.setViewName("viewVehicle");
		return mv;
	}

	@GetMapping(value = "/register-vehicle")
	public ModelAndView displayLoginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addVehicle");
		return mv;
	}

	@PostMapping(value = "/register-vehicle")
	public ModelAndView postRegisterForm(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Vehicle vehicle = new Vehicle();
		Driver driver = session.getAttribute("driver") != null ? (Driver) session.getAttribute("driver") : null;
		System.out.println(driver.getFullName());
		vehicle.setVehicleId(request.getParameter("vehicle"));
		vehicle.setBrand(request.getParameter("brand"));
		vehicle.setType(request.getParameter("type"));
		vehicle.setDriver(driver);
		vehicleDAO.createVehicle(vehicle);
		mv.setViewName("redirect:/view-vehicles");
		return mv;
	}
}
