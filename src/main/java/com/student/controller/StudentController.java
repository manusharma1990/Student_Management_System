package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.Studentdto;
import com.student.model.Student;
import com.student.services.StudentService;
@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	//View Page
	@GetMapping("/viewAll")
	public List<Studentdto> getAll(Model model) {
		List<Studentdto> student = service.getAllStudents();
		//model.addAttribute("students", student);
		return student;
	}
	//registration form
	@GetMapping("/form")
	public String fillform(Model model) {
		
		return "register";
	}
	//save registered data
	@PostMapping("/register")
	public String registration(@RequestBody Student student) {
		return service.registerStudent(student);
	}
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/log")
	public String loginPage() {
		return "login";
	}
	@PostMapping("/loging")
	public void print(@RequestParam String username, @RequestParam String password) {
		System.out.println(username+" "+ password);
	}
}
