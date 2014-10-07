package com.geoffdigital.ngrest.domain.events.students;

import java.util.UUID;

import com.geoffdigital.ngrest.domain.events.CreatedEvent;

public class StudentCreatedEvent extends CreatedEvent {

  private final UUID newStudentId;
  private final StudentDetails details;

  public StudentCreatedEvent(final UUID newStudentId, final StudentDetails details) {
    this.newStudentId = newStudentId;
    this.details = details;
  }

  public StudentDetails getDetails() {
    return details;
  }

  public UUID getNewStudentId() {
    return newStudentId;
  }
  
}
