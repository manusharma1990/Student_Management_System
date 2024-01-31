package com.student.services;

import java.util.List;

import com.student.dto.Studentdto;
import com.student.model.Student;

public interface StudentService {

	List<Studentdto> getAllStudents();
	public String registerStudent(Student student);
	public Studentdto findbyId(long id);
}
