package com.arvind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arvind.entity.Employee;
import com.arvind.entity.User;
import com.arvind.service.EmpService;
import com.arvind.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final EmpService empService;
	private final UserService userService;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUser(user);
		if (status) {
			model.addAttribute("successMsg", "user registered successfully");
		} else {
			model.addAttribute("errorMsg", "user not registered due to some error");
		}
		return "login";
	}

	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	// @PostMapping("/loginForm")
	// public String submitLoginForm(@ModelAttribute("user") User user, Model model)
	// {

	// User validUser = userService.loginUser(user.getEmail(), user.getPassword());
	// if (validUser != null) {
	// // if (validUser.getName() == "admin") {
	// // return "dashboard_admin";
	// // }
	// List<Employee> list = empService.getAllEmp();
	// model.addAttribute("empList", list);
	// return "index";
	// } else {

	// model.addAttribute("errorMsg", "Email id and password didn't matched!!");
	// return "login";
	// }

	// }

	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, HttpSession session, Model model) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if (validUser != null) {
			session.setAttribute("user", validUser); // Set user in session
			List<Employee> list = empService.getAllEmp();
			model.addAttribute("empList", list);
			return "index";
		} else {
			model.addAttribute("errorMsg", "Email id and password didn't match!!");
			return "login";
		}
	}

	@GetMapping("/")
	public String index(Model m) {
		List<Employee> list = empService.getAllEmp();
		m.addAttribute("empList", list);
		return "index";
	}

	@GetMapping("/loadEmpSave")
	public String loadEmpSave() {
		return "emp_save";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Invalidate the session
		return "redirect:/loginPage"; // Redirect to login
	}

	@GetMapping("/EditEmp/{id}")
	public String EditEmp(@PathVariable int id, Model m) {
		// System.out.println(id);
		Employee emp = empService.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";
	}

	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {
		// System.out.println(emp);

		Employee newEmp = empService.saveEmp(emp);

		if (newEmp != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Register sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/loadEmpSave";
	}

	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		// System.out.println(emp);

		Employee updateEmp = empService.saveEmp(emp);

		if (updateEmp != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Update sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/";
	}

	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = empService.deleteEmp(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/";
	}

}
