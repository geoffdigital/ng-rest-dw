package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.ReadEvent;

import java.util.UUID;

public class StudentDetailsEvent extends ReadEvent {

	private UUID id;
	private StudentDetails StudentDetails;

	private StudentDetailsEvent(UUID id) {
		this.id = id;
	}

	public StudentDetailsEvent(UUID id, StudentDetails StudentDetails) {
		this.id = id;
		this.StudentDetails = StudentDetails;
	}

	public UUID getId() {
		return id;
	}

	public StudentDetails getStudentDetails() {
		return StudentDetails;
	}

	public static StudentDetailsEvent notFound(UUID id) {
		StudentDetailsEvent ev = new StudentDetailsEvent(id);
		ev.entityFound=false;
		return ev;
	}
  
}
