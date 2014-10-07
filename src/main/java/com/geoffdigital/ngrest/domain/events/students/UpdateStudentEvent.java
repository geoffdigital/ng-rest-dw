package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.UpdateEvent;

import java.util.UUID;

public class UpdateStudentEvent extends UpdateEvent {

	private UUID id;
	private StudentDetails StudentDetails;

	public UpdateStudentEvent(UUID id, StudentDetails StudentDetails) {
		this.id = id;
		this.StudentDetails = StudentDetails;
	}

	public UUID getId() {
		return id;
	}

	public StudentDetails getStudentDetails() {
		return StudentDetails;
	}
	
}
