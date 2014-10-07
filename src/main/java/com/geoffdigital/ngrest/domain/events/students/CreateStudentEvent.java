package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.CreateEvent;

public class CreateStudentEvent extends CreateEvent {

	private StudentDetails details;

	public CreateStudentEvent(StudentDetails details) {
		this.details = details;
	}

	public StudentDetails getDetails() {
		return details;
	}

}
