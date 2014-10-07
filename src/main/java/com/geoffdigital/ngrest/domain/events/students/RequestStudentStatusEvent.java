package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.RequestReadEvent;

import java.util.UUID;

public class RequestStudentStatusEvent extends RequestReadEvent {

	private UUID id;

	public RequestStudentStatusEvent(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
	
}
