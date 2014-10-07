package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.ReadEvent;

import java.util.UUID;

public class StudentStatusEvent extends ReadEvent {

	private UUID id;
	private StudentStatusDetails StudentStatus;

	private StudentStatusEvent(UUID id) {
		this.id = id;
	}

	public StudentStatusEvent(UUID id, StudentStatusDetails StudentStatus) {
		this.id = id;
		this.StudentStatus = StudentStatus;
	}

	public UUID getId() {
		return id;
	}

	public StudentStatusDetails getStudentStatus() {
		return StudentStatus;
	}

	public static StudentStatusEvent notFound(UUID id) {
		StudentStatusEvent ev = new StudentStatusEvent(id);
		ev.entityFound = false;
		return ev;
	}
	
}
