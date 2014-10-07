package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.UpdatedEvent;

import java.util.UUID;

public class StudentUpdatedEvent extends UpdatedEvent {

	private UUID id;
	private StudentDetails StudentDetails;

	public StudentUpdatedEvent(UUID id, StudentDetails StudentDetails) {
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
