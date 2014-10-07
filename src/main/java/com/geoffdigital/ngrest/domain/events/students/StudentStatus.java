package com.geoffdigital.ngrest.domain.events.students;

import java.util.UUID;

public class StudentStatus {

	private UUID id;

	public StudentStatus() {
		id = null;
	}

	public StudentStatus(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setid(UUID id) {
		this.id = id;
	}
	
}
