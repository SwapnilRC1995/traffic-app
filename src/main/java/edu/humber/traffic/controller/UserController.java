package edu.humber.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.humber.traffic.dao.UserDAO;
import edu.humber.traffic.entity.Driver;
import edu.humber.traffic.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping(value = "/login")
	public ModelAndView displayLoginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@PostMapping(value = "/login")
	public ModelAndView postLoginForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("admin") && password.equals("admin")) {
			mv.setViewName("redirect:/admin-dashboard");
		} else {
			User user = userDAO.getUser(username);
			if (user != null && user.getPassword().equals(password)) {
				mv.setViewName("redirect:/dashboard");
				session.setAttribute("driver", user.getDriver());
				mv.addObject("", null);
			} else {
				mv.setViewName("login");
				mv.addObject("error", "Please login with valid credentials.");
			}
		}

		return mv;
	}

	@GetMapping(value = "/register")
	public ModelAndView displayRegsiterForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	@PostMapping(value = "/register")
	public ModelAndView postRegisterForm(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		Driver driver = new Driver();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		driver.setLicenseNumber(Integer.parseInt(request.getParameter("license")));
		driver.setFullName(request.getParameter("name"));
		driver.setGender(request.getParameter("gender"));
		driver.setAddress(request.getParameter("address"));
		driver.setDateOfBirth(request.getParameter("dob"));
		user.setDriver(driver);
		userDAO.createUser(user);
		session.setAttribute("driver", driver);
		mv.setViewName("login");
		return mv;
	}

}
