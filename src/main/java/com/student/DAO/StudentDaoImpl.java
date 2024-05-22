package com.student.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.student.RowMapper.StudentRowMapper;
import com.student.entity.Student;

@Component
public class StudentDaoImpl implements StudentDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> getAllStudent() {
		String sql= "select * from students";
		List <Student> studentList= jdbcTemplate.query(sql, new StudentRowMapper());
		return studentList;
	}

}
