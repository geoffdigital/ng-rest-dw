package com.geoffdigital.ngrest.application.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geoffdigital.ngrest.application.services.StudentService;
import com.geoffdigital.ngrest.domain.events.students.RequestStudentStatusEvent;
import com.geoffdigital.ngrest.domain.events.students.StudentStatus;
import com.geoffdigital.ngrest.domain.events.students.StudentStatusEvent;

@Controller
@RequestMapping("/aggregators/students/{id}/status")
public class StudentStatusController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<StudentStatus> getStudentStatus(@PathVariable String id) {

		StudentStatusEvent studentStatusEvent = studentService.requestStudentStatus(new RequestStudentStatusEvent(UUID.fromString(id)));

		if (!studentStatusEvent.isEntityFound()) {
			return new ResponseEntity<StudentStatus>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudentStatus>(
				StudentStatus.fromStudentStatusDetails(
						studentStatusEvent.getId(),
						studentStatusEvent.getStudentStatus()),
						HttpStatus.OK);
	}
	
}
