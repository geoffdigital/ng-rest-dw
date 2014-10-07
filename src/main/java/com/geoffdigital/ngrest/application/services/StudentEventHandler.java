package com.geoffdigital.ngrest.application.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.geoffdigital.ngrest.domain.events.students.AllStudentsEvent;
import com.geoffdigital.ngrest.domain.events.students.CreateStudentEvent;
import com.geoffdigital.ngrest.domain.events.students.DeleteStudentEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestAllStudentsEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestStudentDetailsEvent;
import com.geoffdigital.ngrest.domain.events.students.RequestStudentStatusEvent;
import com.geoffdigital.ngrest.domain.events.students.SetStudentPaymentEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentCreatedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDeletedEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentDetails;
import com.geoffdigital.ngrest.domain.events.students.StudentDetailsEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentStatus;
import com.geoffdigital.ngrest.domain.events.students.StudentStatusEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentUpdatedEvent;
import com.geoffdigital.ngrest.domain.model.Student;
import com.geoffdigital.ngrest.infrastructure.repository.StudentsRepository;

public class StudentEventHandler implements StudentService {

	private final StudentsRepository studentsRepository;

	public StudentEventHandler(final StudentsRepository studentsRepository) {
		this.studentsRepository = studentsRepository;
	}

	@Override
	public StudentCreatedEvent createStudent(CreateStudentEvent createStudentEvent) {
		Student student = Student.fromStudentDetails(createStudentEvent.getDetails());

		student.addStatus(new StudentStatus(new Date(), "Student Created"));

		student = studentsRepository.save(student);

		return new StudentCreatedEvent(student.getId(), student.toStudentDetails());
	}

	@Override
	public AllStudentsEvent requestAllStudents(RequestAllStudentsEvent requestAllCurrentStudentsEvent) {
		List<StudentDetails> generatedDetails = new ArrayList<StudentDetails>();
		for (Student student : studentsRepository.findAll()) {
			generatedDetails.add(student.toStudentDetails());
		}
		return new AllStudentsEvent(generatedDetails);
	}

	@Override
	public StudentDetailsEvent requestStudentDetails(RequestStudentDetailsEvent requestStudentDetailsEvent) {
		Student student = studentsRepository.findById(requestStudentDetailsEvent.getId());

		if (student == null) {
			return StudentDetailsEvent.notFound(requestStudentDetailsEvent.getId());
		}

		return new StudentDetailsEvent(requestStudentDetailsEvent.getId(), student.toStudentDetails());
	}

	@Override
	public StudentUpdatedEvent setStudentPayment(SetStudentPaymentEvent setStudentPaymentEvent) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public StudentDeletedEvent deleteStudent(DeleteStudentEvent deleteStudentEvent) {
		Student student = studentsRepository.findById(deleteStudentEvent.getId());

		if (student == null) {
			return StudentDeletedEvent.notFound(deleteStudentEvent.getId());
		}

		StudentDetails details = student.toStudentDetails();

		//TODOCUMENT This contains some specific domain logic, not exposed to the outside world, and not part of the
		//persistence rules.

		if (!student.canBeDeleted()) {
			return StudentDeletedEvent.deletionForbidden(deleteStudentEvent.getId(), details);
		}

		studentsRepository.delete(deleteStudentEvent.getId());
		return new StudentDeletedEvent(deleteStudentEvent.getId(), details);
	}

	@Override
	public StudentStatusEvent requestStudentStatus(RequestStudentStatusEvent requestStudentDetailsEvent) {
		Student student = studentsRepository.findById(requestStudentDetailsEvent.getId());

		if (student == null) {
			return StudentStatusEvent.notFound(requestStudentDetailsEvent.getId());
		}

		return new StudentStatusEvent(requestStudentDetailsEvent.getId(), student.getStatus().toStatusDetails());
	}
	
}
