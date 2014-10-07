package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.DeletedEvent;

import java.util.UUID;

public class StudentDeletedEvent extends DeletedEvent {

	private UUID id;
	private StudentDetails details;
	private boolean deletionCompleted;

	private StudentDeletedEvent(UUID id) {
		this.id = id;
	}

	public StudentDeletedEvent(UUID id, StudentDetails details) {
		this.id = id;
		this.details = details;
		this.deletionCompleted = true;
	}

	public UUID getId() {
		return id;
	}

	public StudentDetails getDetails() {
		return details;
	}

	public boolean isDeletionCompleted() {
		return deletionCompleted;
	}

	public static StudentDeletedEvent deletionForbidden(UUID id, StudentDetails details) {
		StudentDeletedEvent ev = new StudentDeletedEvent(id, details);
		ev.entityFound = true;
		ev.deletionCompleted = false; 
		return ev;
	}

	public static StudentDeletedEvent notFound(UUID id) {
		StudentDeletedEvent ev = new StudentDeletedEvent(id);
		ev.entityFound = false;
		return ev;
	}

}
