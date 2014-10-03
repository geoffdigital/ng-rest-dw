package com.geoffdigital.ngrest.infrastructure.persistance;

import com.geoffdigital.ngrest.domain.model.Student;

public interface StudentDao {
	
	public Student lookupUrl(String url);

}
