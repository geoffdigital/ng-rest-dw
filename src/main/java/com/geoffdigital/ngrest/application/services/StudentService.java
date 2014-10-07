package com.geoffdigital.ngrest.application.services;

import com.geoffdigital.ngrest.domain.events.students.AllStudentsEvent;
import com.geoffdigital.ngrest.domain.events.students.CreateStudentEvent;
import com.geoffdigital.ngrest.domain.events.students.DeleteStudentEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestAllStudentsEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestStudentDetailsEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestStudentStatusEvent;
import com.geoffdigital.ngrest.domain.events.students.SetStudentPaymentEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentCreatedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDeletedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDetailsEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentStatusEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentUpdatedEvent;

//TODOCUMENT THis is an event driven service.
// Used to interact with the core domain.
//All methods are guaranteed to return something, null will never be returned.
public interface StudentService {

	public AllStudentsEvent requestAllStudents(RequestAllStudentsEvent requestAllCurrentStudentsEvent);

	public StudentDetailsEvent requestStudentDetails(RequestStudentDetailsEvent requestStudentDetailsEvent);

	public StudentStatusEvent requestStudentStatus(RequestStudentStatusEvent requestStudentStatusEvent);

	public StudentCreatedEvent createStudent(CreateStudentEvent event);

	public StudentUpdatedEvent setStudentPayment(SetStudentPaymentEvent setStudentPaymentEvent);

	public StudentDeletedEvent deleteStudent(DeleteStudentEvent deleteStudentEvent);

}
