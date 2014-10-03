package com.geoffdigital.ngrest.infrastructure.persistance.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.geoffdigital.ngrest.domain.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Student student = new Student();

		student.setFirstName(resultSet.getString("first_name"));
		student.setLastName(resultSet.getString("last_name"));
		student.setEmail(resultSet.getString("email"));
		student.setMajor(resultSet.getString("major"));

		return student;
	}

}
