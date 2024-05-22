package com.student.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s1= new Student();
		s1.setId(rs.getInt("id"));
		s1.setName(rs.getString("name"));
		s1.setRollNo(rs.getInt("rollNo"));
		s1.setGroupname(rs.getString("groupname"));
		s1.setAddress(rs.getString("address"));
		return s1;
	}

}
