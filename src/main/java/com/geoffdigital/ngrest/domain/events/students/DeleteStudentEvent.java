package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.DeleteEvent;

import java.util.UUID;

public class DeleteStudentEvent extends DeleteEvent {

  private final UUID id;

  public DeleteStudentEvent(final UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }
  
}
