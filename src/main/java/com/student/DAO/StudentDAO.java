package com.student.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentDAO {
	List<Student> getAllStudent();
	
}
