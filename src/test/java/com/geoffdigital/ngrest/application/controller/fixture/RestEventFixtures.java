package com.geoffdigital.ngrest.application.controller.fixture;

import java.util.Date;
import java.util.UUID;

import com.geoffdigital.ngrest.domain.events.students.StudentCreatedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDeletedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDetailsEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentStatusDetails;
import com.geoffdigital.ngrest.domain.events.students.StudentStatusEvent;

import static com.geoffdigital.ngrest.application.controller.fixture.RestDataFixture.customKeyStudentDetails;
import static com.geoffdigital.ngrest.application.controller.fixture.RestDataFixture.standardStudentDetails;

public class RestEventFixtures {
  public static StudentStatusEvent orderStatusNotFound(UUID key) {
    return StudentStatusEvent.notFound(key);
  }
  public static StudentStatusEvent orderStatus(UUID key, String status) {
    return new StudentStatusEvent(key, new StudentStatusDetails(new Date(), status));
  }
  public static StudentDetailsEvent orderDetailsNotFound(UUID key) {
    return StudentDetailsEvent.notFound(key);
  }
  public static StudentDetailsEvent orderDetailsEvent(UUID key) {
    return new StudentDetailsEvent(key, customKeyStudentDetails(key));
  }
  public static StudentCreatedEvent orderCreated(UUID key) {
    return new StudentCreatedEvent(key, customKeyStudentDetails(key));
  }
  public static StudentDeletedEvent orderDeleted(UUID key) {
    return new StudentDeletedEvent(key, standardStudentDetails());
  }
  public static StudentDeletedEvent orderDeletedFailed(UUID key) {
    return StudentDeletedEvent.deletionForbidden(key, standardStudentDetails());
  }
  public static StudentDeletedEvent orderDeletedNotFound(UUID key) {
    return StudentDeletedEvent.notFound(key);
  }
}
