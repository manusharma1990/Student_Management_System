package com.student.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.Studentdto;
import com.student.model.Student;
import com.student.repository.StudentRepo;
@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	@Override
	public List<Studentdto> getAllStudents() {
		List<Student> students = studentRepo.findAll();
		return students.stream().map((student)-> mapToStudentdto(student)).collect(Collectors.toList());
	}
	private Studentdto mapToStudentdto(Student student) {
		Studentdto studentdto = new Studentdto();
		studentdto.setId(student.getId());
		studentdto.setFullname(student.getFullname());
		studentdto.setUsername(student.getUsername());
		studentdto.setAddress(student.getAddress());
		studentdto.setFee(student.getFee());
		studentdto.setJoin_on(student.getJoin_on());
		studentdto.setCourse(student.getCourse());
		return studentdto;
		
	}
	@Override
	public String registerStudent(Student student) {
		studentRepo.save(student);
		return "register";
	}
	@Override
	public Studentdto findbyId(long id) {
		Student student = studentRepo.findById(id).get();
		return mapToStudentdto(student);
	}

}
