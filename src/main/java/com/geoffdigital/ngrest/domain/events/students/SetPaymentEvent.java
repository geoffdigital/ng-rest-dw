package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.UpdateEvent;

import java.util.UUID;

public class SetPaymentEvent extends UpdateEvent {

	private UUID id;
	private StudentDetails studentDetails;

	public SetPaymentEvent(UUID id, StudentDetails studentDetails) {
		this.id = id;
		this.studentDetails = studentDetails;
	}

	public UUID getId() {
		return id;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	
}
