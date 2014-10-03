package com.geoffdigital.ngrest.infrastructure.persistance.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.geoffdigital.ngrest.domain.model.Student;
import com.geoffdigital.ngrest.infrastructure.persistance.StudentDao;

public class JdbcStudentDao implements StudentDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Student lookupUrl(String url) {
		return null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
}
