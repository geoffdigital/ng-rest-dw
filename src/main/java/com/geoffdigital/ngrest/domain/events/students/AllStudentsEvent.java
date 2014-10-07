package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.ReadEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllStudentsEvent extends ReadEvent {

	private final List<StudentDetails> studentsDetails;

	public AllStudentsEvent(List<StudentDetails> students) {
		this.studentsDetails = Collections.unmodifiableList(students);
	}

	public Collection<StudentDetails> getStudentsDetails() {
		return this.studentsDetails;
	}
	
}
