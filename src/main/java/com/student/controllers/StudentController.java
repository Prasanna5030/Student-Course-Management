package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.DAO.StudentDAO;
import com.student.entity.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/home")
	public String studentHome() {
		return "index";
	}
	
	@RequestMapping("/studentlist")
	public String getAllStudents(Model model) {
		List<Student> studentList= studentDAO.getAllStudent();
		System.out.println(studentList);
		model.addAttribute(studentList);
		return "List-students";
	}
}
