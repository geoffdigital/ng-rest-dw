package com.geoffdigital.ngrest.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import com.geoffdigital.ngrest.domain.model.Student;

//TODO, make this event based again, with persistence integration events.
public interface StudentsRepository {

  Student save(Student order);

  void delete(UUID key);

  Student findById(UUID key);

  List<Student> findAll();
}
