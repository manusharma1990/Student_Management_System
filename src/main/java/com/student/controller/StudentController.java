package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.dto.Studentdto;
import com.student.model.Student;
import com.student.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	//View Page
	@GetMapping("/viewAll")
	public String getAll(Model model) {
		List<Studentdto> student = service.getAllStudents();
		model.addAttribute("students", student);
		return "getAll";
	}
	//registration form
	@GetMapping("/form")
	public String fillform(Model model) {
		
		return "register";
	}
	//save registered data
	@PostMapping("/register")
	public String registration(@ModelAttribute Student student) {
		return service.registerStudent(student);
	}
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
}
